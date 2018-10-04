package com.ericshenn.address.addressdetail;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class AddressDetailPresenter extends BasePresenter implements AddressDetailContract.Presenter{
    private AddressDetailContract.View mView;

    public AddressDetailPresenter(@NonNull AddressDetailContract.View view){
        mView = view;
    }

    public AddressDetailPresenter() {
    }
}