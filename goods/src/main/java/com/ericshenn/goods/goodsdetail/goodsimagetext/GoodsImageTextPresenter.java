package com.ericshenn.goods.goodsdetail.goodsimagetext;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class GoodsImageTextPresenter extends BasePresenter implements GoodsImageTextContract.Presenter{
    private GoodsImageTextContract.View mView;

    public GoodsImageTextPresenter(@NonNull GoodsImageTextContract.View view){
        mView = view;
    }

    public GoodsImageTextPresenter() {
    }
}