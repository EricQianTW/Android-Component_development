package com.ericshenn.order.bean;

import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/1/21.
 */

public class OrderTypeInfo {
    @Expose
    private int typeId;

    @Expose
    private String typeName;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public OrderTypeInfo(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public OrderTypeInfo() {
    }
}
