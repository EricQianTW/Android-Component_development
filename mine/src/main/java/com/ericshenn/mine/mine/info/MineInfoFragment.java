package com.ericshenn.mine.mine.info;

import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.constants.Const;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.mine.R;

public class MineInfoFragment extends BaseFragment implements MineInfoContract.View {

    private MineInfoContract.Presenter mPresenter = new MineInfoPresenter(this);
    private TextView tv_name;

    @Override
    public int setLayoutId() {
        return R.layout.mineinfo_frg;
    }

    protected void initView() throws Exception {
        tv_name = layoutView.findViewById(R.id.tv_name);
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
        String userInfo = spUtils.getString(Const.SP_USERINFO);
        ToastUtils.showShort(userInfo);
        tv_name.setText(userInfo);
    }

}