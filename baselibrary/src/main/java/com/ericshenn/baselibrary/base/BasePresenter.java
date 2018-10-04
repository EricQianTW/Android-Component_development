package com.ericshenn.baselibrary.base;

/**
 * Created by eric_qiantw on 16/4/21.
 */
public class BasePresenter {

    // 当前class名
    protected String TAG = this.getClass().getName();

    protected String getCacheTag(String methodName){
        return this.getClass().getSimpleName() + methodName;
    }

}
