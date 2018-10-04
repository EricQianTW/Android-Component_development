package com.ericshenn.goods.shoppingcar;

import android.os.Bundle;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.goods.R;

public class ShoppingCarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_notitle_act);

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new ShoppingCarFragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}