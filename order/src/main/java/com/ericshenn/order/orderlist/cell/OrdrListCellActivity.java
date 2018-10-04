package com.ericshenn.order.orderlist.cell;

import android.os.Bundle;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.order.R;

public class OrdrListCellActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_act);

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new OrdrListCellFragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}