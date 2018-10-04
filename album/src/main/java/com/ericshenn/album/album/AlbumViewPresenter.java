package com.ericshenn.album.album;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class AlbumViewPresenter extends BasePresenter implements AlbumViewContract.Presenter{
    private AlbumViewContract.View mView;

    public AlbumViewPresenter(@NonNull AlbumViewContract.View view){
        mView = view;
    }

    public AlbumViewPresenter() {
    }
}