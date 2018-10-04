package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class WeatherInfo {
    @Expose
    private String city_name;
    @Expose
    private String city_id;
    @Expose
    private String last_update;
    @Expose
    private NowInfo now;
    @Expose
    private TodayInfo today;
    @Expose
    private List<FutureInfo> future;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public NowInfo getNow() {
        return now;
    }

    public void setNow(NowInfo now) {
        this.now = now;
    }

    public TodayInfo getToday() {
        return today;
    }

    public void setToday(TodayInfo today) {
        this.today = today;
    }

    public List<FutureInfo> getFuture() {
        return future;
    }

    public void setFuture(List<FutureInfo> future) {
        this.future = future;
    }
}
