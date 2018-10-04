package com.ericshenn.baselibrary.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by eric on 2016/8/4.
 */
public class ImageViewEquals extends AppCompatImageView {
    int squareDim = 1000000000;

    public ImageViewEquals(Context context) {
        super(context);
    }

    public ImageViewEquals(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewEquals(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int h = this.getMeasuredHeight();
        int w = this.getMeasuredWidth();
        int curSquareDim = Math.min(w, h);
        if (curSquareDim < squareDim) {
            squareDim = curSquareDim;
        }
        setMeasuredDimension(w, w);
    }
}
