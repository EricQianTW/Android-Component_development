package com.ericshenn.goods.bean;

/**
 * Created by pnt_t on 2018/2/5.
 */

public class ClassifyInfo {

    private String name;

    private boolean isChecked;

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

    public ClassifyInfo(String name, boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;
    }

    public ClassifyInfo() {
    }
}
