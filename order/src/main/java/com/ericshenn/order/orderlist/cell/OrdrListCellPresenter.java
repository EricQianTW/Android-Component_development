package com.ericshenn.order.orderlist.cell;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class OrdrListCellPresenter extends BasePresenter implements OrdrListCellContract.Presenter {
    private OrdrListCellContract.View mView;

    public OrdrListCellPresenter(@NonNull OrdrListCellContract.View view) {
        mView = view;
    }

    public OrdrListCellPresenter() {
    }
}