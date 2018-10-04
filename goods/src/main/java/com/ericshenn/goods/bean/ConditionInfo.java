package com.ericshenn.goods.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by pnt_t on 2018/2/9.
 */

public class ConditionInfo {

    @Expose
    private List<ConditionItemInfo> itemArray;

    @Expose
    private int id;

    @Expose
    private String name;

    public List<ConditionItemInfo> getItemArray() {
        return itemArray;
    }

    public void setItemArray(List<ConditionItemInfo> itemArray) {
        this.itemArray = itemArray;
    }

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

    public ConditionInfo(List<ConditionItemInfo> itemArray, int id, String name) {
        this.itemArray = itemArray;
        this.id = id;
        this.name = name;
    }

    public ConditionInfo() {
    }
}
