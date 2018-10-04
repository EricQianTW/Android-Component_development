package com.ericshenn.goods.classify;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.baselibrary.view.pacificadapter.VerticalItemDecoration;
import com.ericshenn.goods.R;
import com.ericshenn.goods.bean.ClassifyInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

public class ClassifyListFragment extends BaseFragment implements ClassifyListContract.View {

    private ClassifyListContract.Presenter mPresenter = new ClassifyListPresenter(this);

    private android.support.v7.widget.RecyclerView rvClassify;
    private android.support.v7.widget.RecyclerView rvGoods;

    private RecyclerAdapter<ClassifyInfo> rvClassifyAdapter;
    private RecyclerAdapter<String> rvGoodsAdapter;
    private int choseIndex = 0;

    @Override
    public int setLayoutId() {
        return R.layout.classifylist_frg;
    }

    @Override
    protected void initView() throws Exception {
        rvClassify = layoutView.findViewById(R.id.rv_classify);
        rvClassify.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvClassify.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_theme)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());

        rvGoods = layoutView.findViewById(R.id.rv_goods);
        rvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvGoods.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_theme)
                .sizeResId(R.dimen.height_explore_divider_20)
                .build());

    }

    @Override
    protected void initAdapter() throws Exception {
        rvClassifyAdapter = new RecyclerAdapter<ClassifyInfo>(getContext(), R.layout.classify_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final ClassifyInfo info) {
                final int pos = helper.getAdapterPosition();
                helper.setText(R.id.tv_name, info.getName());

                if (info.isChecked()) {
                    helper.getItemView().setBackgroundColor(getResources().getColor(R.color.gray_theme));
                }else{
                    helper.getItemView().setBackgroundColor(getResources().getColor(R.color.white));
                }

                helper.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rvClassifyAdapter.getAll().get(choseIndex).setChecked(false);
                        info.setChecked(true);
                        notifyDataSetChanged();
                        choseIndex = pos;
                    }
                });
            }
        };
        rvClassify.setAdapter(rvClassifyAdapter);

        rvGoodsAdapter = new RecyclerAdapter<String>(getContext(), R.layout.classify_item_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {
                RecyclerView rvItem = helper.getView(R.id.rv_item);
                RecyclerAdapter adapter = new RecyclerAdapter<String>(getContext(), R.layout.goods_adp) {
                    @Override
                    protected void convert(RecyclerAdapterHelper helper, String item) {

                    }
                };

                rvItem.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                rvItem.addItemDecoration(new HorizontalItemDecoration
                        .Builder(getContext())
                        .colorResId(R.color.gray_d4)
                        .sizeResId(R.dimen.height_explore_divider_1)
                        .build());

                rvItem.addItemDecoration(new VerticalItemDecoration
                        .Builder(getContext())
                        .colorResId(R.color.gray_d4)
                        .sizeResId(R.dimen.height_explore_divider_1)
                        .build());

                rvItem.setAdapter(adapter);

                for (int i = 0; i < 5; i++) {
                    adapter.add("" + i);
                }

            }
        };
        rvGoods.setAdapter(rvGoodsAdapter);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                rvClassifyAdapter.add(new ClassifyInfo("类型类型" + i, true));
            }else {
                rvClassifyAdapter.add(new ClassifyInfo("类型类型" + i, false));
            }
        }

        for (int i = 0; i < 10; i++) {
            rvGoodsAdapter.add("" + i);
        }
    }

}