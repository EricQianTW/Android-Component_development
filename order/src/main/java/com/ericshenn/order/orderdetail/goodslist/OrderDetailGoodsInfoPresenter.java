package com.ericshenn.order.orderdetail.goodslist;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrderDetailGoodsInfoPresenter extends BasePresenter implements OrderDetailGoodsInfoContract.Presenter{
    private OrderDetailGoodsInfoContract.View mView;

    public OrderDetailGoodsInfoPresenter(@NonNull OrderDetailGoodsInfoContract.View view){
        mView = view;
    }

    public OrderDetailGoodsInfoPresenter() {
    }
}