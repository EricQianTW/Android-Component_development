package com.ericshenn.order.addevaluate2;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class AddEvaluate2Presenter extends BasePresenter implements AddEvaluate2Contract.Presenter{
    private AddEvaluate2Contract.View mView;

    public AddEvaluate2Presenter(@NonNull AddEvaluate2Contract.View view){
        mView = view;
    }

    public AddEvaluate2Presenter() {
    }
}