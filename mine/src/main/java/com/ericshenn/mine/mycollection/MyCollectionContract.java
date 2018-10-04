package com.ericshenn.mine.mycollection;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;

public interface MyCollectionContract {
    interface View extends BaseInterfaceView<Presenter> {
    }

    interface Presenter extends BaseInterfacePresenter {
    }
}