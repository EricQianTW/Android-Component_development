package com.ericshenn.baselibrary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pnt_t on 2018/1/21.
 */

public class CommonPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mTypeNameArr;

    public CommonPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, List<String> typeNameArr) {
        super(fm);
        mFragments = fragments;
        mTypeNameArr = typeNameArr;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTypeNameArr.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

}