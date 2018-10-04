package com.ericshenn.mine.mycollection;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class MyCollectionPresenter extends BasePresenter implements MyCollectionContract.Presenter{
    private MyCollectionContract.View mView;

    public MyCollectionPresenter(@NonNull MyCollectionContract.View view){
        mView = view;
    }

    public MyCollectionPresenter() {
    }
}