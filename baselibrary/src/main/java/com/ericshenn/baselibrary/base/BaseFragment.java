package com.ericshenn.baselibrary.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ericshenn.baselibrary.constants.Const;
import com.ericshenn.baselibrary.utils.SPUtils;

/**
 * Created by eric_clown on 2017/9/27.
 */

public abstract class BaseFragment extends Fragment {

    protected ProgressDialog mDialog;

    protected View layoutView;

    public SPUtils spUtils;

    protected final String TAG = this.getClass().getName();

    /**
     * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑
     * FragmentActivity捕捉到物理返回键点击事件后会首先询问Fragment是否消费该事件
     * 如果没有Fragment消息时FragmentActivity自己才会消费该事件
     */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(setLayoutId(), container, false);

        mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage("加载中...");

        spUtils = new SPUtils(Const.SP_APP_NAME);

        layoutView = rootView;

        try {
            initView();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            initParame();
            initAdapter();

            initAction();
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    protected void initParame() throws Exception {
    }

    protected void initData() throws Exception {
    }

    protected void initAdapter() throws Exception {
    }

    protected void initView() throws Exception {
    }

    protected void initAction() throws Exception {
    }

    public abstract int setLayoutId();

    public void showError(String errorCode, String errorMessage) {
        try {
            ExceptionHandle.handleError(getContext(), errorCode, errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showProDialog() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public void dismissProDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
