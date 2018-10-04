package com.ericshenn.goods.shoppingcar;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.goods.R;
import com.ericshenn.goods.bean.GoodsInfo;
import com.ericshenn.goods.bean.StoreInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCarFragment extends BaseFragment implements ShoppingCarContract.View {

    private ShoppingCarContract.Presenter mPresenter = new ShoppingCarPresenter(this);

    private RecyclerView rvItem;
    private CheckBox cbAll;

    private RecyclerAdapter<StoreInfo> rvItemAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.shoppingcar_frg;
    }

    @Override
    protected void initView() throws Exception {
        cbAll = layoutView.findViewById(R.id.cb_all);
        rvItem = layoutView.findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvItem.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        rvItemAdapter = new RecyclerAdapter<StoreInfo>(getContext(), R.layout.shoppingcar_store_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final StoreInfo info) {
                helper.setText(R.id.tv_storename, info.getStoreName());
                RecyclerView rvGoods = helper.getView(R.id.rv_goods);

                helper.setChecked(R.id.cb_store, info.isChecked());
                helper.setOnCheckedChangeListener(R.id.cb_store, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (!buttonView.isPressed()) {
                            return;
                        }

                        info.setChecked(isChecked);

                        for (GoodsInfo goodsInfo : info.getGoodsList()) {
                            goodsInfo.setChecked(isChecked);
                        }

                        notifyDataSetChanged();

                        setChooseCount();
                    }
                });


                RecyclerAdapter adapter = new RecyclerAdapter<GoodsInfo>(getContext(), R.layout.shoppingcar_goods_adp) {
                    @Override
                    protected void convert(RecyclerAdapterHelper helper, final GoodsInfo item) {
                        helper.setText(R.id.tv_goodsname, item.getGoodsName())
                                .setText(R.id.tv_goodscontent, item.getGoodsContent())
                                .setText(R.id.tv_price, "￥200.00")
                                .setText(R.id.tv_oldprice, "￥200.00")
                                .setText(R.id.tv_count, "X 2")
                        ;

                        helper.setChecked(R.id.cb_goods, item.isChecked());

                        helper.setOnCheckedChangeListener(R.id.cb_goods, new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (!buttonView.isPressed()) {
                                    return;
                                }

                                item.setChecked(isChecked);

                                boolean flag = true;
                                for (GoodsInfo goodsInfo : info.getGoodsList()) {
                                    if (!goodsInfo.isChecked()) {
                                        flag = false;
                                    }
                                }
                                info.setChecked(flag);

                                rvItemAdapter.notifyDataSetChanged();

                                setChooseCount();
                            }
                        });
                    }
                };

                info.setLoadCount(info.getLoadCount() + 1);
                if (info.getLoadCount() == 1) {
                    rvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvGoods.addItemDecoration(new HorizontalItemDecoration
                            .Builder(getContext())
                            .colorResId(R.color.gray_d4)
                            .sizeResId(R.dimen.height_explore_divider_1)
                            .build());
                }

                rvGoods.setAdapter(adapter);

                adapter.addAll(info.getGoodsList());
            }
        };
        rvItem.setAdapter(rvItemAdapter);
    }

    private void setChooseCount() {
        int chooseCount = 0;
        for (StoreInfo info : rvItemAdapter.getAll()) {
            for (GoodsInfo goodsInfo : info.getGoodsList()) {
                if (goodsInfo.isChecked()) {
                    chooseCount++;
                }
            }
        }
        if (chooseCount == 0) {
            cbAll.setText("全选");
        } else {
            cbAll.setText("选中 (" + chooseCount + ") ");
        }
    }

    @Override
    protected void initAction() throws Exception {
        cbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!buttonView.isPressed()) {
                    return;
                }

                for (StoreInfo info : rvItemAdapter.getAll()) {
                    info.setChecked(isChecked);
                    for (GoodsInfo goodsInfo : info.getGoodsList()) {
                        goodsInfo.setChecked(isChecked);
                    }
                }
                rvItemAdapter.notifyDataSetChanged();

                setChooseCount();
            }
        });
    }

    @Override
    protected void initData() throws Exception {
        for (int i = 0; i < 10; i++) {
            StoreInfo info = new StoreInfo();
            info.setStoreName("美商海盗船专卖店");
            List<GoodsInfo> goodsInfos = new ArrayList<>();
            for (int i1 = 0; i1 < 5; i1++) {
                GoodsInfo goodsInfo = new GoodsInfo();
                goodsInfo.setGoodsName("DM商品DM商品DM商品DM商品DM商品DM商品DM商品DM商品DM商品DM商品DM商品DM商品");
                goodsInfo.setGoodsContent("华米 加强版华米 加强版华米 加强版华米 加强版华米 加强版华米 加强版华米 加强版华米 加强版华米 加强版");
                goodsInfos.add(goodsInfo);
            }
            info.setGoodsList(goodsInfos);
            rvItemAdapter.add(info);
        }
    }

}