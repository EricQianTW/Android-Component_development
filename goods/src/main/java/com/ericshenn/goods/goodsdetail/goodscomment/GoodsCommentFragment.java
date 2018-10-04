package com.ericshenn.goods.goodsdetail.goodscomment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.goods.R;
import com.ericshenn.goods.bean.CommentInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

public class GoodsCommentFragment extends BaseFragment implements GoodsCommentContract.View {

    private GoodsCommentContract.Presenter mPresenter = new GoodsCommentPresenter(this);

    private TextView tvCommentcount;
    private TextView tvLikeability;
    private RecyclerView rvComment;

    private RecyclerAdapter<CommentInfo> rvCommentAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.goodscomment_frg;
    }

    @Override
    protected void initView() throws Exception {
        tvCommentcount = layoutView.findViewById(R.id.tv_commentcount);
        tvLikeability = layoutView.findViewById(R.id.tv_likeability);
        rvComment = layoutView.findViewById(R.id.rv_comment);
        rvComment.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvComment.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initAdapter() throws Exception {
        rvCommentAdapter = new RecyclerAdapter<CommentInfo>(getContext(), R.layout.goodscomment_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final CommentInfo info) {
                helper.setImageUrl(R.id.iv_userheader, info.getUserHeader());
                helper.setText(R.id.tv_username, info.getUserName());
                helper.setText(R.id.tv_commentvalue, info.getCommentValue());
                helper.setText(R.id.tv_goodsarr, info.getGoodsAttr());

                RecyclerView rvCommentPic = helper.getView(R.id.rv_commentpic);
                if (info.getCommnetPic() != null && info.getCommnetPic().size() > 0) {

                } else {
                    helper.setVisible(R.id.rv_commentpic, View.GONE);
                }

            }
        };
        rvComment.setAdapter(rvCommentAdapter);
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
        tvCommentcount.setText("评价(1000)");
        tvLikeability.setText("好感度  98%");

        for (int i = 0; i < 3; i++) {
            CommentInfo info = new CommentInfo("用户名", ""
                    , "评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内" +
                    "容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容", "金色，64GB","2018-12-12");
            rvCommentAdapter.add(info);
        }
    }

}