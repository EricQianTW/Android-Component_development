package com.ericshenn.packagemode.index;

import android.content.Context;

import com.ericshenn.baselibrary.base.BaseInterfacePresenter;
import com.ericshenn.baselibrary.base.BaseInterfaceView;

public interface IndexContract {
    interface View extends BaseInterfaceView<Presenter> {
        void setDownloadFileResult(boolean result);
        void setShowCouponResult(String result);
    }

    interface Presenter extends BaseInterfacePresenter {
        void downloadFile(String url, String fileName, Context context);
        void showCoupon(String path);
    }
}