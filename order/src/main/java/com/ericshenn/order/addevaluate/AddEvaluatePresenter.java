package com.ericshenn.order.addevaluate;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class AddEvaluatePresenter extends BasePresenter implements AddEvaluateContract.Presenter{
    private AddEvaluateContract.View mView;

    public AddEvaluatePresenter(@NonNull AddEvaluateContract.View view){
        mView = view;
    }

    public AddEvaluatePresenter() {
    }
}