package com.ericshenn.order.orderdetail.addressinfo;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrderDetailAddressInfoPresenter extends BasePresenter implements OrderDetailAddressInfoContract.Presenter{
    private OrderDetailAddressInfoContract.View mView;

    public OrderDetailAddressInfoPresenter(@NonNull OrderDetailAddressInfoContract.View view){
        mView = view;
    }

    public OrderDetailAddressInfoPresenter() {
    }
}