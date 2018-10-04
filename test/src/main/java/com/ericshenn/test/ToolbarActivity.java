package com.ericshenn.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.test.enums.CollapsingToolbarLayoutState;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pnt_t on 2018/3/1.
 */

public class ToolbarActivity extends BaseActivity {

    private RecyclerView recycler_view;
//    private Banner bnBanner;
    private Toolbar toolbar;
//    private CollapsingToolbarLayout ctoolbar;
//    private AppBarLayout ablMain;
//    private TextView tvTitle;

    private RecyclerAdapter<String> adapter;

    private CollapsingToolbarLayoutState state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_act);

        recycler_view = findViewById(R.id.recycler_view);
        toolbar = findViewById(R.id.toolbar);
//        ctoolbar = findViewById(R.id.ctoolbar);
//        ablMain = findViewById(R.id.abl_main);
//        tvTitle = findViewById(R.id.tv_title);

//        ablMain.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset == 0) {
//                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
//                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
////                        collapsingToolbarLayout.setTitle("EXPANDED");//设置title为EXPANDED
//                        ToastUtils.showShort("EXPANDED");
//                        tvTitle.setVisibility(View.GONE);
//                    }
//                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
////                        collapsingToolbarLayout.setTitle("");//设置title不显示
////                        playButton.setVisibility(View.VISIBLE);//隐藏播放按钮
//                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
//                        ToastUtils.showShort("COLLAPSED");
//                        tvTitle.setVisibility(View.VISIBLE);
//                    }
//                } else {
//                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
////                        if(state == CollapsingToolbarLayoutState.COLLAPSED){
////                            playButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
////                        }
////                        collapsingToolbarLayout.setTitle("INTERNEDIATE");//设置title为INTERNEDIATE
//                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
//                        ToastUtils.showShort("INTERNEDIATE");
//                    }
//                }
//            }
//        });

//        setSupportActionBar(toolbar);//设置toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

////        toolbar.setTitle("好友信息");//设置标题的名字
//        ctoolbar.setCollapsedTitleGravity(Gravity.CENTER_HORIZONTAL);
////        ctoolbar.setCollapsedTitleGravity(Gravity.CENTER);//设置收缩后标题的位置
//        ctoolbar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后标题的颜色
//        ctoolbar.setExpandedTitleGravity(Gravity.TOP);////设置展开后标题的位置
//        ctoolbar.setExpandedTitleColor(Color.WHITE);//设置展开后标题的颜色

//        ToolbarHelper.addMiddleTitle(this, "好友动态", toolbar, R.color.gray_37);

//        bnBanner = findViewById(R.id.bn_banner);
//        initBanner();

        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.addItemDecoration(new HorizontalItemDecoration
                .Builder(this)
                .colorResId(R.color.black)
                .sizeResId(R.dimen.height_explore_divider_1)
                .showLastDivider(true)
                .build());

        adapter = new RecyclerAdapter<String>(getApplicationContext(), R.layout.toolbar_adp) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, final String item) {
                final int position = helper.getAdapterPosition();
                helper.setText(R.id.tv_title, item);
            }
        };

        recycler_view.setAdapter(adapter);

        for (int i = 0; i < 20; i++) {
            adapter.add("测试" + i);
        }

        final List<String> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3463802674,3530626563&fm=27&gp=0.jpg");
        }
//        //设置图片集合
//        bnBanner.setImages(arr);
//        //banner设置方法全部调用完毕时最后调用
//        bnBanner.start();
    }

    private void initBanner() {
        //设置banner样式
//        bnBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
//        //设置图片加载器
//        bnBanner.setImageLoader(new GlideImageLoader());
//        //设置banner动画效果
//        bnBanner.setBannerAnimation(Transformer.Default);
//        //设置标题集合（当banner样式有显示title时）
////        bnBanner.setBannerTitles(titleArr);
//        //设置自动轮播，默认为true
//        bnBanner.isAutoPlay(true);
//        //设置轮播时间
//        bnBanner.setDelayTime(2000);
//        //设置指示器位置（当banner模式中有指示器时）
//        bnBanner.setIndicatorGravity(BannerConfig.CENTER);
//
//        bnBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
    }
}
