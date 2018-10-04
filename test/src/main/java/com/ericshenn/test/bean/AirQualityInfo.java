package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class AirQualityInfo {
    @Expose
    private CityInfo city;
    @Expose
    private String stations;

    public CityInfo getCity() {
        return city;
    }

    public void setCity(CityInfo city) {
        this.city = city;
    }

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }
}
