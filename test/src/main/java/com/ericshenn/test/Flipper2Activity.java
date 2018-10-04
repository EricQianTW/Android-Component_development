package com.ericshenn.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.ericshenn.baselibrary.base.BaseActivity;

/**
 * Created by pnt_t on 2018/3/12.
 */

public class Flipper2Activity extends BaseActivity {

    private ViewFlipper vf;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper_act2);

//        detector = new GestureDetector(this);
//
//        vf = findViewById(R.id.vf);
//        vf.addView(addImageView(R.drawable.default_p));
//        vf.addView(addImageView(R.drawable.icon_draw));
//        vf.addView(addImageView(R.drawable.default_p));
//        vf.addView(addImageView(R.drawable.icon_draw));
//        vf.addView(addImageView(R.drawable.default_p));
//        vf.addView(addImageView(R.drawable.icon_draw));
    }

    private View addImageView(int id) {
        ImageView iv = new ImageView(this);
        iv.setImageResource(id);
        return iv;
    }
}
