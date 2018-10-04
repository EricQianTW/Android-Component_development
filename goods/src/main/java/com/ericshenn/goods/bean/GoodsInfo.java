package com.ericshenn.goods.bean;

/**
 * Created by pnt_t on 2018/2/8.
 */

public class GoodsInfo {

    private boolean isChecked;

    private String goodsName;

    private String goodsContent;

    private String picUrl;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public GoodsInfo(String goodsName, String picUrl,String goodsContent) {
        this.goodsName = goodsName;
        this.picUrl = picUrl;
        this.goodsContent = goodsContent;
    }

    public GoodsInfo(String goodsName, String picUrl) {
        this.goodsName = goodsName;
        this.picUrl = picUrl;
    }

    public GoodsInfo() {
    }
}
