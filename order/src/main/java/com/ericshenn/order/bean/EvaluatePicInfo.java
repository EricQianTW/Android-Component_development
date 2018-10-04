package com.ericshenn.order.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/1/23.
 */

public class EvaluatePicInfo {
    @Expose
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public EvaluatePicInfo(String path) {
        this.path = path;
    }
}
