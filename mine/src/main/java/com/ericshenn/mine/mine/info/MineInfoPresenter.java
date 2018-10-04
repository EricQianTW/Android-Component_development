package com.ericshenn.mine.mine.info;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class MineInfoPresenter extends BasePresenter implements MineInfoContract.Presenter{
    private MineInfoContract.View mView;

    public MineInfoPresenter(@NonNull MineInfoContract.View view){
        mView = view;
    }

    public MineInfoPresenter() {
    }

    @Override
    public void getUserInfo() {

    }
}