package com.ericshenn.mine.personinfo;

import android.os.Bundle;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.mine.R;

public class PersonInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_act);

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new PersonInfoFragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}