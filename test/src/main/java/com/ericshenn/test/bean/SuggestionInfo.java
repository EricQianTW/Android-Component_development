package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class SuggestionInfo {
    @Expose
    private SugBriefInfo dressing;
    @Expose
    private SugBriefInfo uv;
    @Expose
    private SugBriefInfo car_washing;
    @Expose
    private SugBriefInfo travel;
    @Expose
    private SugBriefInfo flu;
    @Expose
    private SugBriefInfo sport;

    public SugBriefInfo getDressing() {
        return dressing;
    }

    public void setDressing(SugBriefInfo dressing) {
        this.dressing = dressing;
    }

    public SugBriefInfo getUv() {
        return uv;
    }

    public void setUv(SugBriefInfo uv) {
        this.uv = uv;
    }

    public SugBriefInfo getCar_washing() {
        return car_washing;
    }

    public void setCar_washing(SugBriefInfo car_washing) {
        this.car_washing = car_washing;
    }

    public SugBriefInfo getTravel() {
        return travel;
    }

    public void setTravel(SugBriefInfo travel) {
        this.travel = travel;
    }

    public SugBriefInfo getFlu() {
        return flu;
    }

    public void setFlu(SugBriefInfo flu) {
        this.flu = flu;
    }

    public SugBriefInfo getSport() {
        return sport;
    }

    public void setSport(SugBriefInfo sport) {
        this.sport = sport;
    }
}
