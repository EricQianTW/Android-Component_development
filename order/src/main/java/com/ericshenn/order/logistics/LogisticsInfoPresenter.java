package com.ericshenn.order.logistics;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class LogisticsInfoPresenter extends BasePresenter implements LogisticsInfoContract.Presenter{
    private LogisticsInfoContract.View mView;

    public LogisticsInfoPresenter(@NonNull LogisticsInfoContract.View view){
        mView = view;
    }

    public LogisticsInfoPresenter() {
    }
}