package com.ericshenn.mine.mine;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;

public interface MineContract {
    interface View extends BaseInterfaceView<Presenter> {
    }

    interface Presenter extends BaseInterfacePresenter {
    }
}