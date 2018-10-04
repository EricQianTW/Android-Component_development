package com.ericshenn.goods.goodsdetail;

import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.goods.R;
import com.ericshenn.goods.goodsdetail.goodscomment.GoodsCommentFragment;
import com.ericshenn.goods.goodsdetail.goodsimagetext.GoodsImageTextFragment;
import com.ericshenn.goods.goodsdetail.goodsinfo.GoodsInfoFragment;

public class GoodsDetailFragment extends BaseFragment implements GoodsDetailContract.View {

    private GoodsDetailContract.Presenter mPresenter = new GoodsDetailPresenter(this);

    @Override
    public int setLayoutId() {
        return R.layout.goodsdetail_frg;
    }

    @Override
    protected void initView() throws Exception {
        try {
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    new GoodsInfoFragment(), R.id.fl_goodsinfo);

            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    new GoodsCommentFragment(), R.id.fl_goodscomment);

            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    new GoodsImageTextFragment(), R.id.fl_goodsimagetext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
    }

}