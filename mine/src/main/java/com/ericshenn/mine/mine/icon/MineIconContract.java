package com.ericshenn.mine.mine.icon;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;
import com.ericshenn.mine.bean.IconInfo;

import java.util.List;

public interface MineIconContract {
    interface View extends BaseInterfaceView<Presenter> {
        void setGetIconResult(List<IconInfo> result);
    }

    interface Presenter extends BaseInterfacePresenter {
        void getIcon();
    }
}