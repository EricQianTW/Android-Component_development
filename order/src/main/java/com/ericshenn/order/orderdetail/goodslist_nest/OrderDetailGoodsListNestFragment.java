package com.ericshenn.order.orderdetail.goodslist_nest;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.order.R;
import com.ericshenn.order.bean.OrderGoodsInfo;
import com.ericshenn.order.bean.OrderStoreInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailGoodsListNestFragment extends BaseFragment implements OrderDetailGoodsListNestContract.View {

    private OrderDetailGoodsListNestContract.Presenter mPresenter = new OrderDetailGoodsListNestPresenter(this);

    private RecyclerView rvStore;

    private RecyclerAdapter<OrderStoreInfo> adapter;

    @Override
    public int setLayoutId() {
        return R.layout.orderdetailgoodslistnest_frg;
    }

    @Override
    protected void initView() throws Exception {
        rvStore = layoutView.findViewById(R.id.rv_store);
        rvStore.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvStore.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_10)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        adapter = new RecyclerAdapter<OrderStoreInfo>(getContext(), R.layout.orderdetailgoodsinfonest_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final OrderStoreInfo info) {
                helper.setText(R.id.tv_storename, "IQOS配件小铺");

                RecyclerAdapter<OrderGoodsInfo> adapterGoods = new RecyclerAdapter<OrderGoodsInfo>(getContext(), R.layout.orderdetailgoodsinfo_adp) {
                    @Override
                    protected void convert(RecyclerAdapterHelper helper, OrderGoodsInfo item) {
                        helper.setText(R.id.tv_goodsprice, "￥260.00")
                                .setText(R.id.tv_goodsoldprice, "￥260.00")
                                .setText(R.id.tv_goodsattr, "颜色分类")
                                .setText(R.id.tv_goodscount, "X 1")
                                .setText(R.id.tv_goodsname, "商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称商品名称");
                        helper.setOnClickListener(R.id.tv_mailehuanq, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                };

                RecyclerView rvGoods = helper.getView(R.id.rv_goods);
                rvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvGoods.addItemDecoration(new HorizontalItemDecoration
                        .Builder(getContext())
                        .colorResId(R.color.gray_d4)
                        .sizeResId(R.dimen.height_explore_divider_1)
                        .build());
                rvGoods.setAdapter(adapterGoods);
                adapterGoods.addAll(info.getGoodsInfo());
            }
        };
        rvStore.setAdapter(adapter);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        List<OrderStoreInfo> arr = new ArrayList<>();
        List<OrderGoodsInfo> arrGoods = new ArrayList<>();
        arrGoods.add(new OrderGoodsInfo());
        arrGoods.add(new OrderGoodsInfo());
        arrGoods.add(new OrderGoodsInfo());
        arr.add(new OrderStoreInfo("", arrGoods));
        arr.add(new OrderStoreInfo("", arrGoods));
        arr.add(new OrderStoreInfo("", arrGoods));
        arr.add(new OrderStoreInfo("", arrGoods));
        adapter.addAll(arr);
    }

}