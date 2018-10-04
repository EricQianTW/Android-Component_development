package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class FutureInfo {
    @Expose
    private String date;
    @Expose
    private String day;
    @Expose
    private String text;
    @Expose
    private String code1;
    @Expose
    private String code2;
    @Expose
    private String high;
    @Expose
    private String low;
    @Expose
    private String cop;
    @Expose
    private String wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
