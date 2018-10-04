package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class TotalInfo {
    @Expose
    private String status;

    @Expose
    private List<WeatherInfo> weather;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }
}
