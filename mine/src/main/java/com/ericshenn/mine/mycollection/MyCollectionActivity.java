package com.ericshenn.mine.mycollection;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.baselibrary.helper.ToolbarHelper;
import com.ericshenn.mine.R;

public class MyCollectionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_clown_act_nomove);

        try {
            ToolbarHelper.addMiddleTitle(this, this.getTitle(), (Toolbar) findViewById(R.id.toolbar), R.color.gray_37);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new MyCollectionFragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}