package com.ericshenn.goods.searchlist;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.SelectorImageView;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.baselibrary.view.pacificadapter.VerticalItemDecoration;
import com.ericshenn.dialogui.DialogUIUtils;
import com.ericshenn.dialogui.bean.PopuBean;
import com.ericshenn.dialogui.listener.TdataListener;
import com.ericshenn.goods.R;
import com.ericshenn.goods.bean.ConditionInfo;
import com.ericshenn.goods.bean.ConditionItemInfo;
import com.ericshenn.goods.bean.GoodsInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchListFragment extends BaseFragment implements SearchListContract.View {

    private SearchListContract.Presenter mPresenter = new SearchListPresenter(this);

    private RecyclerView rvGoods, rvCondition;
    private DrawerLayout mDrawerLayout;
    private SelectorImageView ivSwitch;
    private TextView tvSortlist, tvPreparation;

    private RecyclerAdapter<GoodsInfo> adapterGoods;
    private RecyclerAdapter<ConditionInfo> adapterCondition;
    private List<GoodsInfo> middleArr = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.searchlist_frg;
    }

    @Override
    protected void initView() throws Exception {
        rvGoods = layoutView.findViewById(R.id.rv_goods);
        rvCondition = layoutView.findViewById(R.id.rv_condition);
        rvCondition.setLayoutManager(new LinearLayoutManager(getActivity()));


        mDrawerLayout = layoutView.findViewById(R.id.drawer_main_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.RIGHT);

        ivSwitch = layoutView.findViewById(R.id.iv_switch);
        tvSortlist = layoutView.findViewById(R.id.tv_sortlist);
        tvPreparation = layoutView.findViewById(R.id.tv_preparation);

        setRvLayout();
    }

    private void setRvLayout() {
        if (ivSwitch.isChecked()) {
            rvGoods.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            rvGoods.addItemDecoration(new HorizontalItemDecoration
                    .Builder(getContext())
                    .colorResId(R.color.gray_theme)
                    .sizeResId(R.dimen.height_explore_divider_1)
                    .build());
        } else {
            rvGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvGoods.addItemDecoration(new HorizontalItemDecoration
                    .Builder(getContext())
                    .colorResId(R.color.gray_theme)
                    .sizeResId(R.dimen.height_explore_divider_1)
                    .build());
            rvGoods.addItemDecoration(new VerticalItemDecoration
                    .Builder(getContext())
                    .colorResId(R.color.gray_theme)
                    .sizeResId(R.dimen.height_explore_divider_1)
                    .build());
        }
    }

    @Override
    protected void initAdapter() throws Exception {
        initGoodsAdapter();

        adapterCondition = new RecyclerAdapter<ConditionInfo>(getContext(), R.layout.search_condition_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final ConditionInfo info) {
                helper.setText(R.id.tv_conditionname, "品牌");

                RecyclerAdapter<ConditionItemInfo> adapterGoods = new RecyclerAdapter<ConditionItemInfo>(getContext(), R.layout.search_conditionitem_adp) {
                    @Override
                    protected void convert(RecyclerAdapterHelper helper, final ConditionItemInfo item) {
                        helper.setText(R.id.tv_conditionitemname, item.getName());

                        helper.setVisible(R.id.iv_draw, !item.isChecked() ? View.GONE : View.VISIBLE);

                        helper.getItemView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                item.setChecked(!item.isChecked());
                                notifyDataSetChanged();
                            }
                        });
                    }
                };

                RecyclerView rvGoods = helper.getView(R.id.rv_condition);
                rvGoods.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                rvGoods.setAdapter(adapterGoods);
                adapterGoods.addAll(info.getItemArray());
            }
        };
        rvCondition.setAdapter(adapterCondition);
    }

    private void initGoodsAdapter() {
        adapterGoods = new RecyclerAdapter<GoodsInfo>(getContext(), R.layout.search_listgrid_adp, R.layout.search_listlinear_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final GoodsInfo info) {
                helper.setText(R.id.tv_goodsname, info.getGoodsName())
                        .setImageUrl(R.id.iv_goodspic, info.getPicUrl());
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                int layoutResId;
                if (getViewTypeCount() > 1) {
                    layoutResId = getLayoutResId(viewType);
                } else {
                    layoutResId = layoutResIds[0];
                }
                return new RecyclerView.ViewHolder(layoutInflater.inflate(layoutResId, parent, false)) {
                };
            }

            @Override
            public int getItemViewType(int position) {
                return ivSwitch.isChecked() ? 0 : 1;
            }

            @Override
            public int getLayoutResId(int viewType) {
                if (viewType == 0) {
                    return R.layout.search_listgrid_adp;
                } else {
                    return R.layout.search_listlinear_adp;
                }
            }
        };
        rvGoods.setAdapter(adapterGoods);
    }

    @Override
    protected void initAction() throws Exception {

        ivSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                middleArr.clear();
                middleArr.addAll(adapterGoods.getAll());
                ivSwitch.toggle(!ivSwitch.isChecked());
                setRvLayout();
                try {
                    initGoodsAdapter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                adapterGoods.addAll(middleArr);
            }
        });

        tvSortlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUIUtils.showPopuWindow(getContext(), LinearLayout.LayoutParams.MATCH_PARENT, 3, tvSortlist, new TdataListener() {
                    @Override
                    public void initPupoData(List<PopuBean> lists) {
                        for (int i = 0; i < 3; i++) {
                            PopuBean popu = new PopuBean();
                            popu.setTitle("item" + i);
                            popu.setId(i);
                            lists.add(popu);
                        }
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position) {
                    }
                });
            }
        });

        tvPreparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                        Gravity.RIGHT);
            }
        });

        mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            //在这个方法里可以设置动画效果
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            // 菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {

            }

            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    protected void initData() throws Exception {
        List<GoodsInfo> arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            GoodsInfo goodsInfo = new GoodsInfo("商品" + i, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3463802674,3530626563&fm=27&gp=0.jpg");
            arr.add(goodsInfo);
        }
        adapterGoods.addAll(arr);

        for (int i = 0; i < 10; i++) {
            ConditionInfo conditionInfo = new ConditionInfo();
            conditionInfo.setName("品牌");
            List<ConditionItemInfo> array = new ArrayList<>();
            ConditionItemInfo itemInfo = new ConditionItemInfo();
            itemInfo.setName("冬季");
            array.add(itemInfo);

            ConditionItemInfo itemInfo1 = new ConditionItemInfo();
            itemInfo1.setName("冬季1");
            array.add(itemInfo1);

            ConditionItemInfo itemInfo2 = new ConditionItemInfo();
            itemInfo2.setName("冬季1");
            array.add(itemInfo2);

            ConditionItemInfo itemInfo3 = new ConditionItemInfo();
            itemInfo3.setName("冬季1");
            array.add(itemInfo3);

            conditionInfo.setItemArray(array);
            adapterCondition.add(conditionInfo);
        }
    }

}