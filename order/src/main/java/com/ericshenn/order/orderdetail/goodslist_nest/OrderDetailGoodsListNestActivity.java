package com.ericshenn.order.orderdetail.goodslist_nest;

import android.os.Bundle;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.order.R;

public class OrderDetailGoodsListNestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_act);

        try {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        new OrderDetailGoodsListNestFragment(), R.id.contentFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}