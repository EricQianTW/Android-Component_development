package com.ericshenn.login.login;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.constants.Const;
import com.ericshenn.baselibrary.utils.GSONUtils;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.login.R;
import com.ericshenn.login.bean.UserInfo;

public class LoginFragment extends BaseFragment implements LoginContract.View {

    private LoginContract.Presenter mPresenter = new LoginPresenter(this);
    /**
     * 手机号码
     */
    private AutoCompleteTextView mTvPhonenum;
    /**
     * 密码
     */
    private AutoCompleteTextView mTvPassword;
    /**
     * 登录
     */
    private TextView mTvLogin;
    /**
     * 忘记密码?
     */
    private TextView mTvForgetpsw;

    @Override
    public int setLayoutId() {
        return R.layout.login_frg;
    }

    protected void initView() throws Exception {
        mTvPhonenum = layoutView.findViewById(R.id.tv_phonenum);
        mTvPassword = layoutView.findViewById(R.id.tv_password);
        mTvLogin = layoutView.findViewById(R.id.tv_login);
        mTvForgetpsw = layoutView.findViewById(R.id.tv_forgetpsw);
    }

    protected void initAction() throws Exception {
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo(null, mTvPhonenum.getText().toString(), mTvPassword.getText().toString());
                spUtils.put(Const.SP_USERINFO, GSONUtils.toJson(userInfo));
                ToastUtils.showShort("保存成功");
            }
        });

        mTvForgetpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("保存成功");
            }
        });

    }

    protected void initData() throws Exception {
        mTvPhonenum.setText("dkfjsdlkfjsldkf");
        mTvPassword.setText("dkfjsdlkfjsldkf");
    }
}