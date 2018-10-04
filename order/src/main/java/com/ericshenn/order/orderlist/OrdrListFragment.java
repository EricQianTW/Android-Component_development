package com.ericshenn.order.orderlist;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ericshenn.baselibrary.adapter.CommonPagerAdapter;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.order.R;
import com.ericshenn.order.bean.OrderTypeInfo;
import com.ericshenn.order.orderlist.cell.OrdrListCellFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class OrdrListFragment extends BaseFragment implements OrdrListContract.View, OnTabSelectListener {

    private OrdrListContract.Presenter mPresenter = new OrdrListPresenter(this);

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private List<OrderTypeInfo> orderTypeArr = new ArrayList<>();
    private List<String> orderTypeNameArr = new ArrayList<>();
    private CommonPagerAdapter mAdapter;
    private ViewPager vpMain;
    private SlidingTabLayout stlTitle;
    private int typeId;

    @Override
    public int setLayoutId() {
        return R.layout.ordrlist_frg;
    }

    protected void initView() throws Exception {
        for (int i = 0; i < 6; i++) {
            orderTypeArr.add(new OrderTypeInfo(i, "类型" + i));
        }

        vpMain = layoutView.findViewById(R.id.vp_main);
        stlTitle = layoutView.findViewById(R.id.stl_title);

        for (OrderTypeInfo info : orderTypeArr) {
            mFragments.add(OrdrListCellFragment.getInstance(info));
            orderTypeNameArr.add(info.getTypeName());
        }

        mAdapter = new CommonPagerAdapter(getChildFragmentManager(), mFragments, orderTypeNameArr);
        vpMain.setAdapter(mAdapter);
        vpMain.setOffscreenPageLimit(orderTypeArr.size());

        stlTitle.setViewPager(vpMain);
        stlTitle.setOnTabSelectListener(this);

        for (int i = 0; i < orderTypeArr.size(); i++) {
            if (orderTypeArr.get(i).getTypeId() == typeId) {
                vpMain.setCurrentItem(i);
            }
        }
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
    }

    @Override
    public void onTabSelect(int position) {
    }

    @Override
    public void onTabReselect(int position) {
    }
}