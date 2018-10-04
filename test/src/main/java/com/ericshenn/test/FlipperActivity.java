package com.ericshenn.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.test.view.MyViewFlipper;

/**
 * Created by pnt_t on 2018/3/12.
 */

public class FlipperActivity extends BaseActivity implements MyViewFlipper.OnViewFlipperListener {

    private MyViewFlipper myViewFlipper;
    private int currentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper_act);

        currentNumber = 1;  //默认页号
        myViewFlipper = (MyViewFlipper) findViewById(R.id.body_flipper);
        //给ViewFlipper绑定自定义的滑动监听器
        myViewFlipper.setOnViewFlipperListener(this);
        //初始化页面数据，即View
        myViewFlipper.addView(createView(currentNumber));


    }
    /**获取下一页View**/
    @Override
    public View getNextView() {
        currentNumber = currentNumber == 10 ? 1 : currentNumber + 1;
        return createView(currentNumber);
    }

    /**获取上一页View**/
    @Override
    public View getPreviousView() {
        currentNumber = currentNumber == 1 ? 10 : currentNumber - 1;
        return createView(currentNumber);
    }

    /**更换View数据：这里是根据页号来更换textView上的文字**/
    private View createView(int currentNumber) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        ScrollView resultView = (ScrollView) layoutInflater.inflate(R.layout.flipper_view, null);
        ((TextView) resultView.findViewById(R.id.textView)).setText(currentNumber + "");
        return resultView;
    }
}
