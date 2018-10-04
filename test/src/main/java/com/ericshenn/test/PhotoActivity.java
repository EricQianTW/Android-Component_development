package com.ericshenn.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ericshenn.baselibrary.adapter.CommonPagerAdapter;
import com.ericshenn.test.base.BaseTestActivity;
import com.ericshenn.test.bean.AlbumInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pnt_t on 2018/1/24.
 */

public class PhotoActivity extends BaseTestActivity {

    private ViewPager vpMain;
    private TextView tvIndex, tvCommit;
    private CheckBox cbItem;
    private CommonPagerAdapter mAdapter;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> nameArr = new ArrayList<>();
    private ArrayList<AlbumInfo> listObj = new ArrayList<>();

    private int choseCount = 0;
    private int currentIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_act);

        vpMain = findViewById(R.id.vp_main);
        tvIndex = findViewById(R.id.tv_index);
        tvCommit = findViewById(R.id.tv_commit);
        cbItem = findViewById(R.id.cb_item);

        listObj = (ArrayList<AlbumInfo>) getIntent().getSerializableExtra("listobj");
        choseCount = getIntent().getIntExtra("count", 0);
        currentIndex = getIntent().getIntExtra("position", 0);

        for (AlbumInfo info : listObj) {
            mFragments.add(PhotoCellFragment.getInstance(info));
            nameArr.add(info.getPath());
        }

        mAdapter = new CommonPagerAdapter(getSupportFragmentManager(), mFragments, nameArr);
        vpMain.setAdapter(mAdapter);

        vpMain.setCurrentItem(currentIndex);

        tvIndex.setText(currentIndex + 1 + "/" + listObj.size());

        cbItem.setChecked(listObj.get(currentIndex).isCheck());

        tvCommit.setText("确认(" + choseCount + ")");

        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvIndex.setText(position + 1 + "/" + listObj.size());

                cbItem.setChecked(listObj.get(position).isCheck());

                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("listobj", (Serializable) listObj);
                setResult(1, intent);
                finish();
            }
        });

        cbItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!buttonView.isPressed()) {
                    return;
                }

                listObj.get(currentIndex).setCheck(isChecked);

                if (isChecked) {
                    choseCount++;
                } else {
                    choseCount--;
                }

                tvCommit.setText("确认(" + choseCount + ")");
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("listobj", (Serializable) listObj);
        setResult(1, intent);
        finish();
    }
}
