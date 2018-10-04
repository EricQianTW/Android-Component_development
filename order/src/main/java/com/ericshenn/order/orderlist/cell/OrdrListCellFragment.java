package com.ericshenn.order.orderlist.cell;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.order.R;
import com.ericshenn.order.bean.OrderInfo;
import com.ericshenn.order.bean.OrderTypeInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

public class OrdrListCellFragment extends BaseFragment implements OrdrListCellContract.View {

    private OrdrListCellContract.Presenter mPresenter = new OrdrListCellPresenter(this);

    private OrderTypeInfo mTypeInfo;

    private RecyclerView rvIcon;
    private RecyclerAdapter<OrderInfo> adapter;

    @Override
    public int setLayoutId() {
        return R.layout.ordrlistcell_frg;
    }

    protected void initView() throws Exception {
        rvIcon = layoutView.findViewById(R.id.rv_icon);
        rvIcon.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvIcon.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        adapter = new RecyclerAdapter<OrderInfo>(getContext(), R.layout.orderlistcell_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final OrderInfo info) {

            }
        };
        rvIcon.setAdapter(adapter);
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {

    }

    public static OrdrListCellFragment getInstance(OrderTypeInfo typeInfo) {
        OrdrListCellFragment fragment = new OrdrListCellFragment();
        fragment.mTypeInfo = typeInfo;
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //相当于Fragment的onResume
            ToastUtils.showShort("相当于Fragment的onResume");
        } else {
            //相当于Fragment的onPause
            ToastUtils.showShort("相当于Fragment的onPause");
        }
    }

}