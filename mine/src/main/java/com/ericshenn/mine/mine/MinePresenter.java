package com.ericshenn.mine.mine;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class MinePresenter extends BasePresenter implements MineContract.Presenter{
    private MineContract.View mView;

    public MinePresenter(@NonNull MineContract.View view){
        mView = view;
    }

    public MinePresenter() {
    }
}