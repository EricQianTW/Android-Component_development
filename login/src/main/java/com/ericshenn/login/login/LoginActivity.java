package com.ericshenn.login.login;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.login.R;

@Route(path = "/login/login")
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_notitle_act);

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new LoginFragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}