package com.ericshenn.mine.mine.icon;

import android.support.annotation.NonNull;

import com.ericshenn.baselibrary.base.BasePresenter;
import com.ericshenn.mine.bean.IconInfo;

import java.util.ArrayList;
import java.util.List;

public class MineIconPresenter extends BasePresenter implements MineIconContract.Presenter{
    private MineIconContract.View mView;

    public MineIconPresenter(@NonNull MineIconContract.View view){
        mView = view;
    }

    public MineIconPresenter() {

    }

    @Override
    public void getIcon() {
        List<IconInfo> result = new ArrayList<>();
        IconInfo iconInfo1 = new IconInfo("地址","","");
        IconInfo iconInfo2 = new IconInfo("地址","","");
        IconInfo iconInfo3 = new IconInfo("地址","","");

        IconInfo iconInfo4 = new IconInfo("地址","","");
        IconInfo iconInfo5 = new IconInfo("地址","","");
        IconInfo iconInfo6 = new IconInfo("地址","","");

        result.add(iconInfo1);
        result.add(iconInfo2);
        result.add(iconInfo3);
        result.add(iconInfo4);
        result.add(iconInfo5);
        result.add(iconInfo6);

        mView.setGetIconResult(result);
    }
}