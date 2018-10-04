package com.ericshenn.mine.mine;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.mine.R;
import com.ericshenn.mine.mine.icon.MineIconFragment;
import com.ericshenn.mine.mine.info.MineInfoFragment;
import com.ericshenn.mine.mine.order.MineOrderFragment;

public class MineFragment extends BaseFragment implements MineContract.View {

    private MineContract.Presenter mPresenter = new MinePresenter(this);

    @Override
    public int setLayoutId() {
        return R.layout.mine_frg;
    }

    protected void initView() throws Exception {
        try {
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    new MineInfoFragment(), R.id.infoFrame);

            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    new MineOrderFragment(), R.id.orderFrame);

            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    new MineIconFragment(), R.id.listFrame);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void initAction() throws Exception {
    }

    protected void initData() throws Exception {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //相当于Fragment的onResume
            ToastUtils.showShort("相当于Fragment的onResume");
        } else {
            //相当于Fragment的onPause
            ToastUtils.showShort("相当于Fragment的onPause");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}