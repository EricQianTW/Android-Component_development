package com.ericshenn.order.orderdetail;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.order.R;
import com.ericshenn.order.orderdetail.addressinfo.OrderDetailAddressInfoFragment;
import com.ericshenn.order.orderdetail.goodslist_nest.OrderDetailGoodsListNestFragment;
import com.ericshenn.order.orderdetail.orderinfo.OrderDetailOrderInfoFragment;

public class OrderDetailFragment extends BaseFragment implements OrderDetailContract.View {

    private OrderDetailContract.Presenter mPresenter = new OrderDetailPresenter(this);

    @Override
    public int setLayoutId() {
        return R.layout.orderdetail_frg;
    }

    protected void initView() throws Exception {
        try {
            ActivityUtils.addFragmentToActivity(getFragmentManager(),
                    new OrderDetailAddressInfoFragment(), R.id.addressFrame);

            ActivityUtils.addFragmentToActivity(getFragmentManager(),
                    new OrderDetailGoodsListNestFragment(), R.id.goodsInfoFrame);

            ActivityUtils.addFragmentToActivity(getFragmentManager(),
                    new OrderDetailOrderInfoFragment(), R.id.orderInfoFrame);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
    }

}