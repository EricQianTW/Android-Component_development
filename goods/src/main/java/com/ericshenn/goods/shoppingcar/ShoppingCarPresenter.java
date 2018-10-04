package com.ericshenn.goods.shoppingcar;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class ShoppingCarPresenter extends BasePresenter implements ShoppingCarContract.Presenter{
    private ShoppingCarContract.View mView;

    public ShoppingCarPresenter(@NonNull ShoppingCarContract.View view){
        mView = view;
    }

    public ShoppingCarPresenter() {
    }
}