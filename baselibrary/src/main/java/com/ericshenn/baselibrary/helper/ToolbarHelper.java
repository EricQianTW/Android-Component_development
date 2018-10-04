package com.ericshenn.baselibrary.helper;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ericshenn.baselibrary.R;
import com.ericshenn.baselibrary.utils.SizeUtils;

/**
 * Created by Xingfeng on 2017-03-20.
 */

public class ToolbarHelper {

    public static void addMiddleTitle(Context context, CharSequence title, Toolbar toolbar) {
        addMiddleTitle(context, title, toolbar, R.color.white);
    }

    public static void addMiddleTitle(Context context, CharSequence title, Toolbar toolbar, int textColorId) {

        TextView textView = new TextView(context);
        textView.setText(title);
        textView.setTextColor(context.getResources().getColor(textColorId));
        textView.setTextSize(18);

        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        toolbar.addView(textView, params);

    }

    public static void addRightText(Context context, CharSequence title, Toolbar toolbar, int textColorId) {

        TextView textView = new TextView(context);
        textView.setText(title);
        textView.setTextColor(context.getResources().getColor(textColorId));
        textView.setTextSize(16);

        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        params.setMarginEnd(SizeUtils.dp2px(10));
        params.gravity = Gravity.RIGHT;
        toolbar.addView(textView, params);

    }

    public static void addRightImage(Context context, int title, Toolbar toolbar, int textColorId) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(title);

        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        params.setMarginEnd(SizeUtils.dp2px(10));
        params.gravity = Gravity.RIGHT;
        toolbar.addView(imageView, params);

    }

}
