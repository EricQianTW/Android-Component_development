package com.ericshenn.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.baselibrary.helper.ToolbarHelper;
import com.ericshenn.test.bean.AlbumInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

/**
 * Created by pnt_t on 2018/2/5.
 */

public class GoodsList extends BaseActivity {

    private RecyclerAdapter<AlbumInfo> adapter;

    private RecyclerView rvItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_act);

        Toolbar toolbar = findViewById(R.id.toolbar);
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        Toolbar toolbar3 = findViewById(R.id.toolbar3);

//        rvItem = findViewById(R.id.rv_item);

//        rvItem.setLayoutManager(new LinearLayoutManager(this));
//        rvItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        rvItem.addItemDecoration(new GridLayoutItemDecoration(2, LinearLayout.VERTICAL, 10, 10));
//        rvItem.addItemDecoration(new GridLayoutItemDecoration(2, LinearLayout.HORIZONTAL, 10, 10));
//        rvItem.addItemDecoration(new HorizontalItemDecoration
//                .Builder(this)
//                .colorResId(R.color.black)
//                .sizeResId(R.dimen.height_explore_divider_20)
//                .showLastDivider(true)
//                .build());

//        rvItem.addItemDecoration(new VerticalItemDecoration
//                .Builder(this)
//                .colorResId(R.color.black)
//                .sizeResId(R.dimen.height_explore_divider_20)
//                .build());

        ToolbarHelper.addMiddleTitle(this, "好友动态", toolbar, R.color.gray_37);


        ToolbarHelper.addMiddleTitle(this, "好友动态", toolbar1, R.color.gray_37);
        ToolbarHelper.addRightImage(this, R.drawable.icon_rightarrow, toolbar1, R.color.gray_37);

        ToolbarHelper.addMiddleTitle(this, "好友动态", toolbar2, R.color.gray_37);
        ToolbarHelper.addRightText(this, "提交", toolbar2, R.color.gray_37);

//        ToolbarHelper.addRightText(this, "取消", toolbar3, R.color.gray_37);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        adapter = new RecyclerAdapter<AlbumInfo>(getApplicationContext(), R.layout.goods_adp) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, final AlbumInfo item) {
                final int position = helper.getAdapterPosition();
                helper.setText(R.id.name, item.getPath());
                if (item.isCheck()) {
                    helper.getItemView().setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    helper.getItemView().setBackgroundColor(getResources().getColor(R.color.white));
                }

                helper.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!v.isPressed()) {
                            return;
                        }
                        for (AlbumInfo albumInfo : adapter.getAll()) {
                            albumInfo.setCheck(false);
                        }
                        item.setCheck(true);
                        notifyDataSetChanged();

                        if (position + 3 < 0) {
                            rvItem.smoothScrollBy(0, 0);
                        } else {
                            rvItem.smoothScrollBy(position + 100, 0);
                        }


                    }
                });
            }
        };

//        rvItem.setAdapter(adapter);

        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                adapter.add(new AlbumInfo("测试" + i, true));
            } else {
                adapter.add(new AlbumInfo("测试" + i, false));
            }
        }
    }
}
