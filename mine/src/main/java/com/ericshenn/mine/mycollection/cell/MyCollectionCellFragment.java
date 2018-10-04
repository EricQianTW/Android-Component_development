package com.ericshenn.mine.mycollection.cell;

import android.support.v7.widget.LinearLayoutManager;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.mine.R;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

public class MyCollectionCellFragment extends BaseFragment implements MyCollectionCellContract.View {

    private MyCollectionCellContract.Presenter mPresenter = new MyCollectionCellPresenter(this);

    private String mTypeInfo;

    private android.support.v7.widget.RecyclerView rvCollection;

    private RecyclerAdapter<String> rvCollectionAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.mycollectioncell_frg;
    }

    @Override
    protected void initView() throws Exception {
        rvCollection = layoutView.findViewById(R.id.rv_collection);
        rvCollection.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCollection.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        rvCollectionAdapter = new RecyclerAdapter<String>(getContext(), R.layout.mycollectioncell_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {
//                helper.setImageUrl(R.id.iv_header, "");

                helper.setText(R.id.tv_name, "小卷纸");

                helper.setText(R.id.tv_content, "100%原浆，遇水即化");

                helper.setText(R.id.tv_price, "￥20.00");
            }
        };
        rvCollection.setAdapter(rvCollectionAdapter);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        for (int i = 0; i < 20; i++) {
            rvCollectionAdapter.add("ffs" + i);
        }
    }

    public static MyCollectionCellFragment getInstance(String typeInfo) {
        MyCollectionCellFragment fragment = new MyCollectionCellFragment();
        fragment.mTypeInfo = typeInfo;
        return fragment;
    }

}