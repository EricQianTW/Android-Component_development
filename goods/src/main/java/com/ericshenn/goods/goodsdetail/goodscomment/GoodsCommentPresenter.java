package com.ericshenn.goods.goodsdetail.goodscomment;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class GoodsCommentPresenter extends BasePresenter implements GoodsCommentContract.Presenter{
    private GoodsCommentContract.View mView;

    public GoodsCommentPresenter(@NonNull GoodsCommentContract.View view){
        mView = view;
    }

    public GoodsCommentPresenter() {
    }
}