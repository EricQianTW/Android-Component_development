package com.ericshenn.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ericshenn.baselibrary.base.BaseActivity;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 * Created by pnt_t on 2018/2/11.
 */

public class PullDownActivity extends BaseActivity implements BGASwipeBackHelper.Delegate{

    protected BGASwipeBackHelper mSwipeBackHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initSwipeBackFinish();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pulldown_act);

//        SwipeBackHelper.onCreate(this);

//        SwipeBackHelper.getCurrentPage(this)//get current instance
//                .setSwipeBackEnable(true)//on-off
//                .setSwipeEdge(200)//set the touch area。200 mean only the left 200px of screen can touch to begin swipe.
//                .setSwipeEdgePercent(0.2f)//0.2 mean left 20% of screen can touch to begin swipe.
//                .setSwipeSensitivity(0.5f)//sensitiveness of the gesture。0:slow  1:sensitive
//                .setScrimColor(Color.BLUE)//color of Scrim below the activity
//                .setClosePercent(0.8f)//close activity when swipe over this
//                .setSwipeRelateEnable(false)//if should move together with the following Activity
//                .setSwipeRelateOffset(500)//the Offset of following Activity when setSwipeRelateEnable(true)
//                .setDisallowInterceptTouchEvent(true)//your view can hand the events first.default false;
//                .addListener(new SwipeListener() {
//
//                    @Override
//                    public void onScroll(float percent, int px) {
//                    }
//
//                    @Override
//                    public void onEdgeTouch() {
//                    }
//
//                    @Override
//                    public void onScrollToClose() {
//                    }
//                });

        // Init the swipe back
//        SwipeBack.attach(this, Position.LEFT)
//                .setContentView(R.layout.pulldown_act)
//                .setSwipeBackTransformer(new SlideSwipeBackTransformer())
//                .setSwipeBackView(R.layout.back_test_layout)
//                .setSwipeBackContainerBackgroundColor(R.color.gray);
//        SwipeBack.attach(this, Position.LEFT)
//                .setDrawOverlay(true)
//                .setDivider(R.color.red)
//                .setDividerEnabled(true) // Must be called to enable, setDivider() is not enough
//                .setSwipeBackTransformer(new SlideSwipeBackTransformer())
//                .setContentView(R.layout.pulldown_act)
//                .setSwipeBackView(R.layout.back_test_layout);
    }

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private void initSwipeBackFinish() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(true);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        mSwipeBackHelper.setIsNavigationBarOverlap(false);
    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @Override
    public void onSwipeBackLayoutCancel() {
    }

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    @Override
    public void onBackPressed() {
        // 正在滑动返回的时候取消返回按钮事件
        if (mSwipeBackHelper.isSliding()) {
            return;
        }
        mSwipeBackHelper.backward();
    }

//    @Override
//    public void onBackPressed(){
//        super.onBackPressed();
//        overridePendingTransition(R.anim.swipeback_stack_to_front,
//                R.anim.swipeback_stack_right_out);
//    }

}
