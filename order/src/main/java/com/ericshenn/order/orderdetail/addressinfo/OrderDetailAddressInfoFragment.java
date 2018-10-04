package com.ericshenn.order.orderdetail.addressinfo;

import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.order.R;

public class OrderDetailAddressInfoFragment extends BaseFragment implements OrderDetailAddressInfoContract.View {

    private OrderDetailAddressInfoContract.Presenter mPresenter = new OrderDetailAddressInfoPresenter(this);
    private TextView mTvUsername, mTvPhonenum, mTvAddress;

    @Override
    public int setLayoutId() {
        return R.layout.orderdetailaddressinfo_frg;
    }

    protected void initView() throws Exception {
        mTvUsername = layoutView.findViewById(R.id.tv_username);
        mTvPhonenum = layoutView.findViewById(R.id.tv_phonenum);
        mTvAddress = layoutView.findViewById(R.id.tv_address);
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
        mTvUsername.setText("收货人: 钱谭伟");
        mTvPhonenum.setText("13739146726");
        mTvAddress.setText("收货地址: 江苏省南通市江苏省南通市江苏省南通市江苏省南通市江苏省南通市江苏省南通市江苏省南通市");
    }
}