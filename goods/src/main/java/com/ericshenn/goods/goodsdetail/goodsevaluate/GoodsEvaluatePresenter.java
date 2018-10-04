package com.ericshenn.goods.goodsdetail.goodsevaluate;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class GoodsEvaluatePresenter extends BasePresenter implements GoodsEvaluateContract.Presenter{
    private GoodsEvaluateContract.View mView;

    public GoodsEvaluatePresenter(@NonNull GoodsEvaluateContract.View view){
        mView = view;
    }

    public GoodsEvaluatePresenter() {
    }
}