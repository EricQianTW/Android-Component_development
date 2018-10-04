package com.ericshenn.goods.goodsdetail.goodsinfo;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.GlideImageLoader;
import com.ericshenn.dialogui.DialogUIUtils;
import com.ericshenn.goods.R;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class GoodsInfoFragment extends BaseFragment implements GoodsInfoContract.View {

    private GoodsInfoContract.Presenter mPresenter = new GoodsInfoPresenter(this);

    private TextView tvGoodsname, tvGoodsfav, tvPrice, tvChoiced, tvSend, tvAddressinfo, tvExpressinfo, tvExpressamount;
    private LinearLayout llCardcoupons, llChoiced, llSalespromotion;
    private RecyclerView rvCardcoupons, rvSalespromotion, rvTips;
    private ImageView ivIcon;
    private Banner bnBanner;

    private RecyclerAdapter<String> rvCardcouponsAdapter;
    private RecyclerAdapter<String> rvSalespromotionAdapter;
    private RecyclerAdapter<String> rvTipsAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.goodsinfo_frg;
    }

    @Override
    protected void initView() throws Exception {
        ivIcon = layoutView.findViewById(R.id.iv_icon);

        bnBanner = layoutView.findViewById(R.id.bn_banner);
        initBanner();

        tvGoodsname = layoutView.findViewById(R.id.tv_goodsname);
        tvGoodsfav = layoutView.findViewById(R.id.tv_goodsfav);
        tvPrice = layoutView.findViewById(R.id.tv_price);
        tvChoiced = layoutView.findViewById(R.id.tv_choiced);
        tvSend = layoutView.findViewById(R.id.tv_send);
        tvAddressinfo = layoutView.findViewById(R.id.tv_addressinfo);
        tvExpressinfo = layoutView.findViewById(R.id.tv_expressinfo);
        tvExpressamount = layoutView.findViewById(R.id.tv_expressamount);

        llCardcoupons = layoutView.findViewById(R.id.ll_cardcoupons);
        llSalespromotion = layoutView.findViewById(R.id.ll_salespromotion);
        llChoiced = layoutView.findViewById(R.id.ll_choiced);

        rvCardcoupons = layoutView.findViewById(R.id.rv_cardcoupons);
        rvCardcoupons.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rvSalespromotion = layoutView.findViewById(R.id.rv_salespromotion);
        rvSalespromotion.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvTips = layoutView.findViewById(R.id.rv_tips);
        rvTips.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initBanner() {
        //设置banner样式
        bnBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        bnBanner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        bnBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
//        bnBanner.setBannerTitles(titleArr);
        //设置自动轮播，默认为true
        bnBanner.isAutoPlay(true);
        //设置轮播时间
        bnBanner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        bnBanner.setIndicatorGravity(BannerConfig.CENTER);

        bnBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected void initAdapter() throws Exception {
        rvCardcouponsAdapter = new RecyclerAdapter<String>(getContext(), R.layout.goodsinfo_cardcoupons_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {
                helper.setText(R.id.tv_cardcoupons, info);
            }
        };
        rvCardcoupons.setAdapter(rvCardcouponsAdapter);

        rvSalespromotionAdapter = new RecyclerAdapter<String>(getContext(), R.layout.goodsinfo_salespromotion_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {
                helper.setText(R.id.tv_salespromotion, info);
            }
        };
        rvSalespromotion.setAdapter(rvSalespromotionAdapter);

        rvTipsAdapter = new RecyclerAdapter<String>(getContext(), R.layout.goodsinfo_tips_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {
                helper.setText(R.id.tv_tips, info);
            }
        };
        rvTips.setAdapter(rvTipsAdapter);
    }

    @Override
    protected void initAction() throws Exception {
        llChoiced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View rootViewB = View.inflate(getActivity(), R.layout.choice_bottom_layout, null);
                DialogUIUtils.showCustomBottomAlert(getContext(), rootViewB, false).show();
            }
        });
    }

    @Override
    protected void initData() throws Exception {
        tvGoodsname.setText("玩具玩具柜玩具玩具柜玩具玩具柜玩具玩具柜玩具玩具柜玩具玩具柜玩具玩具柜玩具玩具柜玩具玩具柜");
        tvGoodsfav.setText("优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息");
        tvPrice.setText("￥3435.00");

        for (int i = 0; i < 5; i++) {
            rvCardcouponsAdapter.add("满减" + i);
        }

        for (int i = 0; i < 1; i++) {
            rvSalespromotionAdapter.add("多买优惠多买优惠多买优惠多买优惠多买优惠" + i);
        }

        tvChoiced.setText("hello kitty, 1件");
        tvAddressinfo.setText("江苏>南通市>崇川区>城区");
        tvExpressinfo.setText("现货，23:00前下单，预计12月12日(周日)送达");
        tvExpressamount.setText("在线支付免运费");

        for (int i = 0; i < 2; i++) {
            rvTipsAdapter.add("京东发货&店铺售后" + i);
        }

        final List<String> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3463802674,3530626563&fm=27&gp=0.jpg");
        }
        //设置图片集合
        bnBanner.setImages(arr);
        //banner设置方法全部调用完毕时最后调用
        bnBanner.start();
    }

}