package com.ericshenn.goods.goodsdetail.goodsinfo;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class GoodsInfoPresenter extends BasePresenter implements GoodsInfoContract.Presenter{
    private GoodsInfoContract.View mView;

    public GoodsInfoPresenter(@NonNull GoodsInfoContract.View view){
        mView = view;
    }

    public GoodsInfoPresenter() {
    }
}