package com.ericshenn.address.addresslist;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;

public class AddressListPresenter extends BasePresenter implements AddressListContract.Presenter{
    private AddressListContract.View mView;

    public AddressListPresenter(@NonNull AddressListContract.View view){
        mView = view;
    }

    public AddressListPresenter() {
    }
}