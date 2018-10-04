package com.ericshenn.goods.searchlist;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;

public interface SearchListContract {
    interface View extends BaseInterfaceView<Presenter> {
    }

    interface Presenter extends BaseInterfacePresenter {
    }
}