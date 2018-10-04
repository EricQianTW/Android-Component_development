package com.ericshenn.mine.mine.order;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.mine.R;

public class MineOrderFragment extends BaseFragment implements MineOrderContract.View {

    private MineOrderContract.Presenter mPresenter = new MineOrderPresenter(this);

    @Override
    public int setLayoutId() {
        return R.layout.mineorder_frg;
    }

    protected void initView() throws Exception {
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
    }

}