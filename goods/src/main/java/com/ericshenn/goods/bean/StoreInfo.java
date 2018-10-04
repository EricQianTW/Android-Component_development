package com.ericshenn.goods.bean;

import java.util.List;

/**
 * Created by pnt_t on 2018/2/15.
 */

public class StoreInfo {

    private boolean isChecked;

    private String storeName;

    private List<GoodsInfo> goodsList;

    private int loadCount = 0;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getLoadCount() {
        return loadCount;
    }

    public void setLoadCount(int loadCount) {
        this.loadCount = loadCount;
    }
}
