package com.ericshenn.packagemode;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ericshenn.baselibrary.base.BaseActivity;

/**
 * Created by pnt_t on 2018/1/19.
 */

@Route(path = "/test/activity")
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
