package com.ericshenn.mine.setup;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class SetUpPresenter extends BasePresenter implements SetUpContract.Presenter{
    private SetUpContract.View mView;

    public SetUpPresenter(@NonNull SetUpContract.View view){
        mView = view;
    }

    public SetUpPresenter() {
    }
}