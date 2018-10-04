package com.ericshenn.home.home1;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.home.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_notitle_act);

        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    new HomeFragment(), R.id.contentFrame);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}