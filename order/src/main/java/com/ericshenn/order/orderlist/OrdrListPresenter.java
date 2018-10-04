package com.ericshenn.order.orderlist;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrdrListPresenter extends BasePresenter implements OrdrListContract.Presenter{
    private OrdrListContract.View mView;

    public OrdrListPresenter(@NonNull OrdrListContract.View view){
        mView = view;
    }

    public OrdrListPresenter() {
    }
}