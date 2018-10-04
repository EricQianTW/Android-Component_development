package com.ericshenn.goods.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/2/9.
 */

public class ConditionItemInfo {

    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private boolean isChecked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public ConditionItemInfo(int id, String name, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
    }

    public ConditionItemInfo() {
    }
}
