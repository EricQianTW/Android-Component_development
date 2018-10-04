package com.ericshenn.mine.personinfo;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class PersonInfoPresenter extends BasePresenter implements PersonInfoContract.Presenter{
    private PersonInfoContract.View mView;

    public PersonInfoPresenter(@NonNull PersonInfoContract.View view){
        mView = view;
    }

    public PersonInfoPresenter() {
    }
}