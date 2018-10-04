package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class TodayInfo {
    @Expose
    private String sunrise;
    @Expose
    private String sunset;
    @Expose
    private SuggestionInfo suggestion;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public SuggestionInfo getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionInfo suggestion) {
        this.suggestion = suggestion;
    }
}
