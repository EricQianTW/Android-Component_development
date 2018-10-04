package com.ericshenn.order.orderdetail.goodslist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.order.R;
import com.ericshenn.order.bean.OrderGoodsInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailGoodsInfoFragment extends BaseFragment implements OrderDetailGoodsInfoContract.View {

    private OrderDetailGoodsInfoContract.Presenter mPresenter = new OrderDetailGoodsInfoPresenter(this);
    private RecyclerView mRvGoods;

    private RecyclerAdapter<OrderGoodsInfo> adapter;

    @Override
    public int setLayoutId() {
        return R.layout.orderdetailgoodsinfo_frg;
    }

    protected void initView() throws Exception {
        mRvGoods = layoutView.findViewById(R.id.rv_goods);
        mRvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvGoods.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        adapter = new RecyclerAdapter<OrderGoodsInfo>(getContext(), R.layout.orderdetailgoodsinfo_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final OrderGoodsInfo info) {
                helper.setText(R.id.tv_goodsprice,"￥260.00")
                        .setText(R.id.tv_goodsoldprice,"￥260.00")
                        .setText(R.id.tv_goodsattr,"颜色分类")
                        .setText(R.id.tv_goodscount,"X 1")
                        .setText(R.id.tv_goodsname,"商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称");
                helper.setOnClickListener(R.id.tv_mailehuanq, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        };
        mRvGoods.setAdapter(adapter);
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
        List<OrderGoodsInfo> arr = new ArrayList<>();
        arr.add(new OrderGoodsInfo());
        arr.add(new OrderGoodsInfo());
        arr.add(new OrderGoodsInfo());
        adapter.addAll(arr);
    }

}