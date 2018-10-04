package com.ericshenn.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pnt_t on 2018/1/10.
 */

public class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    public void onBackPressed() {
        // Fragment 返回按钮
//        if (mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()) {
//            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
//                getSupportFragmentManager().popBackStack();
//            }
//        }
//        super.onBackPressed();
        AppManager.getAppManager().finishActivity();
//        finish();
    }
}
