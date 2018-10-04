package com.ericshenn.mine.personinfo;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.mine.R;

public class PersonInfoFragment extends BaseFragment implements PersonInfoContract.View {

    private PersonInfoContract.Presenter mPresenter = new PersonInfoPresenter(this);

    @Override
    public int setLayoutId() {
        return R.layout.personinfo_frg;
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