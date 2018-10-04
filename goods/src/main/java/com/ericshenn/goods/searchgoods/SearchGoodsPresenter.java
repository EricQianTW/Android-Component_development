package com.ericshenn.goods.searchgoods;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class SearchGoodsPresenter extends BasePresenter implements SearchGoodsContract.Presenter{
    private SearchGoodsContract.View mView;

    public SearchGoodsPresenter(@NonNull SearchGoodsContract.View view){
        mView = view;
    }

    public SearchGoodsPresenter() {
    }
}