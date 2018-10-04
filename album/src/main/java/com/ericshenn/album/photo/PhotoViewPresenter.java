package com.ericshenn.album.photo;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class PhotoViewPresenter extends BasePresenter implements PhotoViewContract.Presenter{
    private PhotoViewContract.View mView;

    public PhotoViewPresenter(@NonNull PhotoViewContract.View view){
        mView = view;
    }

    public PhotoViewPresenter() {
    }
}