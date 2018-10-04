package com.ericshenn.address.addresslist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ericshenn.address.R;
import com.ericshenn.address.addressdetail.AddressDetailActivity;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.IntentUtils;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

public class AddressListFragment extends BaseFragment implements AddressListContract.View {

    private AddressListContract.Presenter mPresenter = new AddressListPresenter(this);

    private RecyclerAdapter<String> adapter;
    private RecyclerView rvItem;

    @Override
    public int setLayoutId() {
        return R.layout.addresslist_frg;
    }

    @Override
    protected void initView() throws Exception {
        rvItem = layoutView.findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvItem.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_theme)
                .sizeResId(R.dimen.height_explore_divider_10)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        adapter = new RecyclerAdapter<String>(getActivity(), R.layout.addresslist_adp) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, final String item) {
                final int position = helper.getAdapterPosition();
                helper.setText(R.id.tv_username, "用户名")
                        .setText(R.id.tv_phone, "13739146726")
                        .setText(R.id.tv_address, "地址的详情信息地址的详情信息地址的详情信息地址的详情信息地址的详情信息地址的详情信息")
                ;

                helper.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!v.isPressed()) {
                            return;
                        }
                        IntentUtils.startActivity(getActivity(), AddressDetailActivity.class);
                    }
                });
            }
        };
        rvItem.setAdapter(adapter);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        for (int i = 0; i < 20; i++) {
            adapter.add("Test" + i);
        }
    }

}