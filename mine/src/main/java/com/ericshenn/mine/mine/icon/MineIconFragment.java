package com.ericshenn.mine.mine.icon;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.IntentUtils;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.mine.R;
import com.ericshenn.mine.bean.IconInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.List;

public class MineIconFragment extends BaseFragment implements MineIconContract.View {

    private MineIconContract.Presenter mPresenter = new MineIconPresenter(this);

    private RecyclerView rv_icon;

    private RecyclerAdapter<IconInfo> adapter;

    @Override
    public int setLayoutId() {
        return R.layout.mineicon_frg;
    }

    protected void initView() throws Exception {
        rv_icon = layoutView.findViewById(R.id.rv_icon);
        rv_icon.setLayoutManager(new GridLayoutManager(getActivity(),4));
        rv_icon.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        adapter = new RecyclerAdapter<IconInfo>(getContext(), R.layout.mineicon_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final IconInfo info) {
                helper.setText(R.id.tv_content, info.getContent())
                        .setImageUrl(R.id.iv_icon, info.getIconUrl())
                .getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        IntentUtils.startSchemeIntent(getActivity(),info.getClickUrl());
                    }
                });
            }
        };
        rv_icon.setAdapter(adapter);
    }

    protected void initAction() throws Exception {

    }

    protected void initData() throws Exception {
        mPresenter.getIcon();
    }

    @Override
    public void setGetIconResult(List<IconInfo> result) {
        adapter.replaceAll(result);
    }
}