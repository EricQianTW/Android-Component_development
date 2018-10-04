package com.ericshenn.album.photo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ericshenn.album.R;
import com.ericshenn.baselibrary.adapter.CommonPagerAdapter;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.bean.AlbumInfo;
import com.ericshenn.baselibrary.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotoViewFragment extends BaseFragment implements PhotoViewContract.View {

    private TextView tvIndex;
    private CheckBox cbItem;
    private TextView tvCommit;
    private ViewPager vpMain;

    private CommonPagerAdapter mAdapter;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> nameArr = new ArrayList<>();
    private ArrayList<AlbumInfo> listObj = new ArrayList<>();

    private int choseCount = 0;
    private int currentIndex = 0;
    private int maxCount = 1;

    @Override
    public int setLayoutId() {
        return R.layout.photoview_frg;
    }

    @Override
    protected void initView() throws Exception {
        tvIndex = layoutView.findViewById(R.id.tv_index);
        cbItem = layoutView.findViewById(R.id.cb_item);
        tvCommit = layoutView.findViewById(R.id.tv_commit);
        vpMain = layoutView.findViewById(R.id.vp_main);
    }

    @Override
    protected void initParame() throws Exception {
        listObj = (ArrayList<AlbumInfo>) getArguments().getSerializable(PhotoViewActivity.LISTOBJ);
        choseCount = getArguments().getInt(PhotoViewActivity.COUNT);
        currentIndex = getArguments().getInt(PhotoViewActivity.POSITION);
        maxCount = getArguments().getInt(PhotoViewActivity.MAXCOUNT);
    }

    @Override
    protected void initAction() throws Exception {
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

        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(PhotoViewActivity.LISTOBJ, (Serializable) listObj);
                intent.putExtra(PhotoViewActivity.COUNT, choseCount);
                getActivity().setResult(1, intent);
                getActivity().finish();
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
                    if (choseCount == maxCount) {
                        cbItem.setChecked(false);
                        ToastUtils.showShort("最多选择" + maxCount + "个");
                        return;
                    } else {
                        choseCount++;
                    }
                } else {
                    choseCount--;
                }

                tvCommit.setText("确认(" + choseCount + ")");
            }
        });
    }

    @Override
    protected void initData() throws Exception {
        for (AlbumInfo info : listObj) {
            mFragments.add(PhotoCellFragment.getInstance(info));
            nameArr.add(info.getPath());
        }

        mAdapter = new CommonPagerAdapter(getFragmentManager(), mFragments, nameArr);
        vpMain.setAdapter(mAdapter);

        vpMain.setCurrentItem(currentIndex);

        tvIndex.setText(currentIndex + 1 + "/" + listObj.size());

        cbItem.setChecked(listObj.get(currentIndex).isCheck());

        tvCommit.setText("确认(" + choseCount + ")");
    }

    @Override
    public void onDestroy() {
        Intent intent = new Intent();
        intent.putExtra(PhotoViewActivity.LISTOBJ, (Serializable) listObj);
        intent.putExtra(PhotoViewActivity.COUNT, choseCount);
        getActivity().setResult(2, intent);
        getActivity().finish();
        super.onDestroy();
    }
}