package com.ericshenn.order.addevaluate2;

import android.os.Bundle;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.order.R;

public class AddEvaluate2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_notitle_act);

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new AddEvaluate2Fragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}