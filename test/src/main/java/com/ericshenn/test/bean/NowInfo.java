package com.ericshenn.test.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class NowInfo {
    @Expose
    private String text;
    @Expose
    private String code;
    @Expose
    private String temperature;
    @Expose
    private String feels_like;
    @Expose
    private String wind_direction;
    @Expose
    private String wind_speed;
    @Expose
    private String wind_scale;
    @Expose
    private String humidity;
    @Expose
    private String visibility;
    @Expose
    private String pressure;
    @Expose
    private String pressure_rising;
    @Expose
    private AirQualityInfo air_quality;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_scale() {
        return wind_scale;
    }

    public void setWind_scale(String wind_scale) {
        this.wind_scale = wind_scale;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPressure_rising() {
        return pressure_rising;
    }

    public void setPressure_rising(String pressure_rising) {
        this.pressure_rising = pressure_rising;
    }

    public AirQualityInfo getAir_quality() {
        return air_quality;
    }

    public void setAir_quality(AirQualityInfo air_quality) {
        this.air_quality = air_quality;
    }
}
