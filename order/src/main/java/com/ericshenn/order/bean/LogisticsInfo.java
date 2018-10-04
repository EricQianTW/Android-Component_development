package com.ericshenn.order.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by cc on 2016/8/3.
 */
public class LogisticsInfo {
    @Expose
    private String time;

    @Expose
    private String info;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LogisticsInfo(String time, String info) {
        this.time = time;
        this.info = info;
    }

    public LogisticsInfo() {
    }
}
