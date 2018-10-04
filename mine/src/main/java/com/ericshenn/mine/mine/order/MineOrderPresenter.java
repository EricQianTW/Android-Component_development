package com.ericshenn.mine.mine.order;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class MineOrderPresenter extends BasePresenter implements MineOrderContract.Presenter{
    private MineOrderContract.View mView;

    public MineOrderPresenter(@NonNull MineOrderContract.View view){
        mView = view;
    }

    public MineOrderPresenter() {
    }
}