package com.ericshenn.order.orderdetail;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrderDetailPresenter extends BasePresenter implements OrderDetailContract.Presenter{
    private OrderDetailContract.View mView;

    public OrderDetailPresenter(@NonNull OrderDetailContract.View view){
        mView = view;
    }

    public OrderDetailPresenter() {
    }
}