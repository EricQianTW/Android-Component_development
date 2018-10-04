package com.ericshenn.order.orderdetail.goodslist_nest;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrderDetailGoodsListNestPresenter extends BasePresenter implements OrderDetailGoodsListNestContract.Presenter{
    private OrderDetailGoodsListNestContract.View mView;

    public OrderDetailGoodsListNestPresenter(@NonNull OrderDetailGoodsListNestContract.View view){
        mView = view;
    }

    public OrderDetailGoodsListNestPresenter() {
    }
}