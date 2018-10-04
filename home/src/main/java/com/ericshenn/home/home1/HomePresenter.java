package com.ericshenn.home.home1;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class HomePresenter extends BasePresenter implements HomeContract.Presenter{
    private HomeContract.View mView;

    public HomePresenter(@NonNull HomeContract.View view){
        mView = view;
    }

    public HomePresenter() {
    }
}