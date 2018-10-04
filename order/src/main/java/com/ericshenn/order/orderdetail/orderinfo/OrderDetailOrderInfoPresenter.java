package com.ericshenn.order.orderdetail.orderinfo;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrderDetailOrderInfoPresenter extends BasePresenter implements OrderDetailOrderInfoContract.Presenter{

    private OrderDetailOrderInfoContract.View mView;

    public OrderDetailOrderInfoPresenter(@NonNull OrderDetailOrderInfoContract.View view){
        mView =view;
    }

    public OrderDetailOrderInfoPresenter() {
    }
}