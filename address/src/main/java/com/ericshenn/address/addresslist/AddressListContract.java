package com.ericshenn.address.addresslist;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;

public interface AddressListContract {
    interface View extends BaseInterfaceView<Presenter> {
    }

    interface Presenter extends BaseInterfacePresenter {
    }
}