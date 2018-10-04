package com.ericshenn.packagemode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    /**
     * Login Module
     */
    private TextView mTvLogin;
    /**
     * Mine Module
     */
    private TextView mTvMine;
    /**
     * Login Module
     */
    private TextView mTvGoods;
    /**
     * Mine Module
     */
    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAction();
    }

    private void initAction() {
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/login/login").navigation();
            }
        });

        mTvMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/app/index").navigation();
            }
        });

        mTvGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/goods/search").navigation();
            }
        });

        mTvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test/room").navigation();
            }
        });
    }

    private void initView() {
        mTvLogin = findViewById(R.id.tv_login);
        mTvMine = findViewById(R.id.tv_mine);
        mTvGoods = findViewById(R.id.tv_goods);
        mTvTest = findViewById(R.id.tv_test);
    }
}
