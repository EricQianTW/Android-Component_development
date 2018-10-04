package com.ericshenn.order.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by pnt_t on 2018/1/23.
 */

public class OrderStoreInfo {

    @Expose
    private String storeName;

    @Expose
    private List<OrderGoodsInfo> goodsInfo;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<OrderGoodsInfo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<OrderGoodsInfo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public OrderStoreInfo(String storeName, List<OrderGoodsInfo> goodsInfo) {
        this.storeName = storeName;
        this.goodsInfo = goodsInfo;
    }

    public OrderStoreInfo() {
    }
}
