package com.ericshenn.order.orderdetail.orderinfo;

import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.StringUtils;
import com.ericshenn.order.R;

public class OrderDetailOrderInfoFragment extends BaseFragment implements OrderDetailOrderInfoContract.View {

    private OrderDetailOrderInfoContract.Presenter mPresenter = new OrderDetailOrderInfoPresenter(this);

    private TextView tvOrderNum, tvOrderTime, tvPayWay, tvSendWay, tvSendTime, tvActualAmount;

    @Override
    public int setLayoutId() {
        return R.layout.orderdetailorderinfo_frg;
    }

    protected void initView() throws Exception {
        tvOrderNum = layoutView.findViewById(R.id.tv_ordernum);
        tvOrderTime = layoutView.findViewById(R.id.tv_ordertime);
        tvPayWay = layoutView.findViewById(R.id.tv_payway);
        tvSendWay = layoutView.findViewById(R.id.tv_sendway);
        tvSendTime = layoutView.findViewById(R.id.tv_sendtime);
        tvActualAmount = layoutView.findViewById(R.id.tv_actualamount);
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
        tvOrderNum.setText(StringUtils.stringXmlformat(getContext(), R.string.orderinfo_ordernum, "70727186611"));
        tvOrderTime.setText(StringUtils.stringXmlformat(getContext(), R.string.orderinfo_ordertime, "2018-01-23 9:00-15:00"));
        tvPayWay.setText(StringUtils.stringXmlformat(getContext(), R.string.orderinfo_payway, "快捷支付"));
        tvSendWay.setText(StringUtils.stringXmlformat(getContext(), R.string.orderinfo_sendway, "京东快递"));
        tvSendTime.setText(StringUtils.stringXmlformat(getContext(), R.string.orderinfo_sendtime, "2018-01-23,9:00-15:00"));
        tvActualAmount.setText(StringUtils.stringXmlformat(getContext(), R.string.orderinfo_actualamount, "￥0.90"));
    }

}