package com.ericshenn.home.home1;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.home.R;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter mPresenter = new HomePresenter(this);


    @Override
    public int setLayoutId() {
        return R.layout.home_frg;
    }

    @Override
    protected void initView() throws Exception {
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
    }

}