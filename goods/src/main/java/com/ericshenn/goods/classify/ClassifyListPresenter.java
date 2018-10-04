package com.ericshenn.goods.classify;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class ClassifyListPresenter extends BasePresenter implements ClassifyListContract.Presenter{
    private ClassifyListContract.View mView;

    public ClassifyListPresenter(@NonNull ClassifyListContract.View view){
        mView = view;
    }

    public ClassifyListPresenter() {
    }
}