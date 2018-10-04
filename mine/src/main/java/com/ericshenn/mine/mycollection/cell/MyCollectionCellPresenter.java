package com.ericshenn.mine.mycollection.cell;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class MyCollectionCellPresenter extends BasePresenter implements MyCollectionCellContract.Presenter{
    private MyCollectionCellContract.View mView;

    public MyCollectionCellPresenter(@NonNull MyCollectionCellContract.View view){
        mView = view;
    }

    public MyCollectionCellPresenter() {
    }
}