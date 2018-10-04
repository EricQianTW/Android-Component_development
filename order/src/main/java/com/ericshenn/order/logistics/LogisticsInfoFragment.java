package com.ericshenn.order.logistics;

import android.widget.ImageView;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.StringUtils;
import com.ericshenn.baselibrary.view.stepview.StepView;
import com.ericshenn.order.R;
import com.ericshenn.order.bean.LogisticsInfo;

import java.util.ArrayList;
import java.util.List;

public class LogisticsInfoFragment extends BaseFragment implements LogisticsInfoContract.View {

    private LogisticsInfoContract.Presenter mPresenter = new LogisticsInfoPresenter(this);

    private StepView svMain;
    private ImageView ivGoodspic;
    private TextView tvState, tvLogisticsnum, tvPhonenum;

    @Override
    public int setLayoutId() {
        return R.layout.logisticsinfo_frg;
    }

    @Override
    protected void initView() throws Exception {
        svMain = layoutView.findViewById(R.id.sv_main);
        ivGoodspic = layoutView.findViewById(R.id.iv_goodspic);
        tvState = layoutView.findViewById(R.id.tv_state);
        tvLogisticsnum = layoutView.findViewById(R.id.tv_logisticsnum);
        tvPhonenum = layoutView.findViewById(R.id.tv_phonenum);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        tvState.setText("已签收");
        tvLogisticsnum.setText(StringUtils.stringXmlformat(getContext(),R.string.logisticsinfo_logisticsnum,"45345646546546"));
        tvPhonenum.setText(StringUtils.stringXmlformat(getContext(),R.string.logisticsinfo_phonenum,"324234234234"));

        List<LogisticsInfo> array = new ArrayList<>();
        array.add(new LogisticsInfo("2012-12-12 12:12:12", "到达南通"));
        array.add(new LogisticsInfo("2012-12-12 12:12:12", "到达南通"));
        array.add(new LogisticsInfo("2012-12-12 12:12:12", "到达南通"));
        array.add(new LogisticsInfo("2012-12-12 12:12:12", "到达南通"));
        array.add(new LogisticsInfo("2012-12-12 12:12:12", "到达南通"));

        svMain.setDatas(array);
        // 设置view的绑定监听
        svMain.setBindViewListener(new StepView.BindViewListener() {
            @Override
            public void onBindView(TextView itemMsg, TextView itemDate, Object data) {
                LogisticsInfo sid = (LogisticsInfo) data;
                itemMsg.setText(sid.getInfo());
                itemDate.setText(sid.getTime());
            }
        });
    }

}