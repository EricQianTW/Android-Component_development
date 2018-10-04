package com.ericshenn.goods.searchgoods;

import android.arch.persistence.room.Room;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.AppManager;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.KeyboardUtils;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.baselibrary.view.FluidLayout;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.goods.R;
import com.ericshenn.roomdb.bean.SearchHistory;
import com.ericshenn.roomdb.dao.SearchHistoryDao;
import com.ericshenn.roomdb.database.SearchHistoryDatabase;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchGoodsFragment extends BaseFragment implements SearchGoodsContract.View {

    private SearchGoodsContract.Presenter mPresenter = new SearchGoodsPresenter(this);

    private FluidLayout fluidLayout;
    private RecyclerView rvHistory;
    private ImageView ivBack;
    private TextView tvSearch;
    private EditText etKeyword;

    private RecyclerAdapter<String> rvHistoryAdapter;
    private final Handler mHandler = new Handler();
    private SearchHistoryDatabase searchHistoryDB;
    private SearchHistoryDao searchHistoryDao;

    private String[] tags = new String[]{
            "倩女幽魂", "单机斗地主", "天堂战记", "妖精的尾巴", "极限挑战", "我们相爱吧", "倚天屠龙记",
            "明星大侦探", "丰乳肥臀", "大主宰", "盗墓笔记", "鬼吹灯"};

    @Override
    public int setLayoutId() {
        return R.layout.searchgoods_frg;
    }

    @Override
    protected void initView() throws Exception {
        fluidLayout = layoutView.findViewById(R.id.fl_icons);
        ivBack = layoutView.findViewById(R.id.iv_back);
        tvSearch = layoutView.findViewById(R.id.tv_search);
        etKeyword = layoutView.findViewById(R.id.et_keyword);
        rvHistory = layoutView.findViewById(R.id.rv_history);
        rvHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHistory.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_theme)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());

        searchHistoryDB = Room.databaseBuilder(getContext(), SearchHistoryDatabase.class, "searchhistory").build();
        searchHistoryDao = searchHistoryDB.getSearchHistoryDao();
    }

    @Override
    protected void initAdapter() throws Exception {
        rvHistoryAdapter = new RecyclerAdapter<String>(getContext(), R.layout.search_history_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final String info) {
                helper.setText(R.id.tv_history, info);
                helper.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        };
        rvHistory.setAdapter(rvHistoryAdapter);
    }

    @Override
    protected void initAction() throws Exception {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().finishActivity();
            }
        });

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBykeyword();
            }
        });

        etKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    ToastUtils.showShort("搜索");
                    handled = true;

                    searchBykeyword();
                }
                return handled;
            }
        });
    }

    private void searchBykeyword() {
        if ("".equals(etKeyword.getText().toString())) {
            ToastUtils.showShort("请输入检索关键字");
            return;
        }

        KeyboardUtils.hideSoftInput(getActivity());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SearchHistory searchHistory = new SearchHistory();
                searchHistory.historyItem = etKeyword.getText().toString();
                searchHistory.updateTime = System.currentTimeMillis();

                searchHistoryDao.insertUser(searchHistory);
            }
        }).start();
    }

    @Override
    protected void initData() throws Exception {
        fluidLayout.setGravity(Gravity.TOP);
        for (int i = 0; i < tags.length; i++) {
            final TextView tv = new TextView(getActivity());
            tv.setText(tags[i]);
            tv.setTextSize(13);

            tv.setBackgroundResource(R.drawable.fliudlayout_text_bg_highlight);

            tv.setTextColor(Color.parseColor("#666666"));

            FluidLayout.LayoutParams params = new FluidLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(12, 12, 12, 12);
            fluidLayout.addView(tv, params);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShort(tv.getText().toString());
                }
            });
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<SearchHistory> temp = searchHistoryDao.getAllSearchHistory();
                final List<String> history = new ArrayList<>();
                for (SearchHistory searchHistory : temp) {
                    history.add(searchHistory.historyItem);
                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        rvHistoryAdapter.addAll(history);
                    }
                });
            }
        }).start();

    }

}