package com.ericshenn.login.login;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter{
    private LoginContract.View mView;

    public LoginPresenter(@NonNull LoginContract.View view){
        mView = view;
    }

    public LoginPresenter() {
    }
}