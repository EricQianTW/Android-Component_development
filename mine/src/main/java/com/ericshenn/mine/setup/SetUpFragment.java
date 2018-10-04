package com.ericshenn.mine.setup;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.mine.R;

public class SetUpFragment extends BaseFragment implements SetUpContract.View {

    private SetUpContract.Presenter mPresenter = new SetUpPresenter(this);

    @Override
    public int setLayoutId() {
        return R.layout.setup_frg;
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