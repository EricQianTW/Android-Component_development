package com.ericshenn.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ericshenn.baselibrary.base.BaseActivity;

/**
 * Created by pnt_t on 2018/3/2.
 */

public class ToolbarActivity2 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar2_act);

//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
//        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
//        mCollapsingToolbarLayout.setTitle("好友信息");
//        //通过CollapsingToolbarLayout修改字体颜色
//        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
//        mCollapsingToolbarLayout.setExpandedTitleGravity(Gravity.TOP);//设置还没收缩时状态下字体颜色
//        mCollapsingToolbarLayout.setExpandedTitleMarginTop(SizeUtils.dp2px(15));//设置还没收缩时状态下字体颜色
//        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.BlueText);//设置还没收缩时状态下字体颜色
//        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
//        mCollapsingToolbarLayout.setCollapsedTitleGravity(Gravity.CENTER_HORIZONTAL);//设置收缩后Toolbar上字体的颜色
    }
}
