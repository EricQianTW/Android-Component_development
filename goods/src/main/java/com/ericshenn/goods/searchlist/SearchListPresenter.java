package com.ericshenn.goods.searchlist;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class SearchListPresenter extends BasePresenter implements SearchListContract.Presenter{
    private SearchListContract.View mView;

    public SearchListPresenter(@NonNull SearchListContract.View view){
        mView = view;
    }

    public SearchListPresenter() {
    }
}