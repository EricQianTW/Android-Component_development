package com.ericshenn.address.addressdetail;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ericshenn.address.R;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.baselibrary.view.picker.AddressPickTask;

import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

public class AddressDetailFragment extends BaseFragment implements AddressDetailContract.View {

    private AddressDetailContract.Presenter mPresenter = new AddressDetailPresenter(this);

    private EditText etReceivename;
    private EditText etPhone;
    private TextView tvPcd;
    private TextView tvPcdinfo;
    private LinearLayout llPcd;
    private TextView etPaddress;
    private EditText etPostnum;
    private EditText etDetailaddress;
    private TextView tvCommit;

    @Override
    public int setLayoutId() {
        return R.layout.addressdetail_frg;
    }

    @Override
    protected void initView() throws Exception {
        etReceivename = layoutView.findViewById(R.id.et_receivename);
        llPcd = layoutView.findViewById(R.id.ll_pcd);
        etPhone = layoutView.findViewById(R.id.et_phone);
        tvPcd = layoutView.findViewById(R.id.tv_pcd);
        tvPcdinfo = layoutView.findViewById(R.id.tv_pcdinfo);
        etPaddress = layoutView.findViewById(R.id.et_paddress);
        etPostnum = layoutView.findViewById(R.id.et_postnum);
        etDetailaddress = layoutView.findViewById(R.id.et_detailaddress);
        tvCommit = layoutView.findViewById(R.id.tv_commit);
    }

    @Override
    protected void initAction() throws Exception {
        llPcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressPickTask task = new AddressPickTask(getActivity());
                task.setHideProvince(false);
                task.setHideCounty(false);
                task.setCallback(new AddressPickTask.Callback() {
                    @Override
                    public void onAddressInitFailed() {
                        ToastUtils.showShort("数据初始化失败");
                    }

                    @Override
                    public void onAddressPicked(Province province, City city, County county) {
                        if (county == null) {
                            tvPcdinfo.setText(province.getAreaName() + city.getAreaName());
                        } else {
                            tvPcdinfo.setText(province.getAreaName() + city.getAreaName() + county.getAreaName());
                        }
                    }
                });
                task.execute("北京市", "北京市", "东城区");
            }
        });
    }

    @Override
    protected void initData() throws Exception {
    }

}