package com.ericshenn.album.photo;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;

public interface PhotoViewContract {
    interface View extends BaseInterfaceView<Presenter> {
    }

    interface Presenter extends BaseInterfacePresenter {
    }
}