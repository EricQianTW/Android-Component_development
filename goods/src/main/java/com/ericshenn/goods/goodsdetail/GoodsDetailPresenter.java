package com.ericshenn.goods.goodsdetail;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class GoodsDetailPresenter extends BasePresenter implements GoodsDetailContract.Presenter{
    private GoodsDetailContract.View mView;

    public GoodsDetailPresenter(@NonNull GoodsDetailContract.View view){
        mView = view;
    }

    public GoodsDetailPresenter() {
    }
}