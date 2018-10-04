package com.ericshenn.mine.mycollection;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ericshenn.baselibrary.adapter.CommonPagerAdapter;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.mine.R;
import com.ericshenn.mine.mycollection.cell.MyCollectionCellFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MyCollectionFragment extends BaseFragment implements MyCollectionContract.View {

    private MyCollectionContract.Presenter mPresenter = new MyCollectionPresenter(this);

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    //    private List<String> orderTypeArr = new ArrayList<>();
//    private List<String> orderTypeNameArr = new ArrayList<>();
    private CommonPagerAdapter mAdapter;
    private ViewPager vpMain;
    private SlidingTabLayout stlTitle;
    private String[] titleArray = {"店铺", "商品"};

    @Override
    public int setLayoutId() {
        return R.layout.mycollection_frg;
    }

    @Override
    protected void initView() throws Exception {
//        for (int i = 0; i < 2; i++) {
//            orderTypeArr.add("类型" + i);
//        }
//
//        for (String s : titleArray) {
//            orderTypeArr.ad
//        }

        vpMain = layoutView.findViewById(R.id.vp_main);
        stlTitle = layoutView.findViewById(R.id.stl_title);

        for (String info : titleArray) {
            mFragments.add(MyCollectionCellFragment.getInstance(info));
        }

        mAdapter = new CommonPagerAdapter(getChildFragmentManager(), mFragments, Arrays.asList(titleArray));
        vpMain.setAdapter(mAdapter);
        vpMain.setOffscreenPageLimit(titleArray.length);

        stlTitle.setViewPager(vpMain);

//        for (int i = 0; i < orderTypeArr.size(); i++) {
//            if (orderTypeArr.get(i).getTypeId() == typeId) {
//                vpMain.setCurrentItem(i);
//            }
//        }
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
    }

}