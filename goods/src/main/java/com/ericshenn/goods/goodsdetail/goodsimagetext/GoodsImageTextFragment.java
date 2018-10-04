
package com.ericshenn.goods.goodsdetail.goodsimagetext;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.goods.R;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

public class GoodsImageTextFragment extends BaseFragment implements GoodsImageTextContract.View {

    private GoodsImageTextContract.Presenter mPresenter = new GoodsImageTextPresenter(this);

    private RecyclerView rvImagetext;

    private RecyclerAdapter<String> rvImagetextAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.goodsimagetext_frg;
    }

    @Override
    protected void initView() throws Exception {
        rvImagetext = layoutView.findViewById(R.id.rv_imagetext);
        rvImagetext.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initAdapter() throws Exception {
        rvImagetextAdapter = new RecyclerAdapter<String>(getContext(), R.layout.goodsimagetext_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {

            }
        };
        rvImagetext.setAdapter(rvImagetextAdapter);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        for (int i = 0; i < 10; i++) {
            rvImagetextAdapter.add("");
        }
    }

}