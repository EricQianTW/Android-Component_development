package com.ericshenn.login.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/1/19.
 */

public class UserInfo {
    @Expose
    private String userName;

    @Expose
    private String password;

    @Expose
    private String phoneNum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public UserInfo(String userName, String password, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public UserInfo() {
    }
}
