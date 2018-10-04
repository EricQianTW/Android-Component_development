package com.ericshenn.goods.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by pnt_t on 2018/2/9.
 */

public class CommentInfo {

    @Expose
    private String userName;

    @Expose
    private String userHeader;

    @Expose
    private String userRating;

    @Expose
    private String commentValue;

    @Expose
    private String goodsAttr;

    @Expose
    private String evaluateDate;

    @Expose
    private String buyDate;

    @Expose
    private List<String> commnetPic;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeader() {
        return userHeader;
    }

    public void setUserHeader(String userHeader) {
        this.userHeader = userHeader;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(String commentValue) {
        this.commentValue = commentValue;
    }

    public String getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(String goodsAttr) {
        this.goodsAttr = goodsAttr;
    }

    public List<String> getCommnetPic() {
        return commnetPic;
    }

    public void setCommnetPic(List<String> commnetPic) {
        this.commnetPic = commnetPic;
    }

    public String getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(String evaluateDate) {
        this.evaluateDate = evaluateDate;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public CommentInfo(String userName, String userHeader, String userRating, String commentValue, String goodsAttr, List<String> commnetPic) {
        this.userName = userName;
        this.userHeader = userHeader;
        this.userRating = userRating;
        this.commentValue = commentValue;
        this.goodsAttr = goodsAttr;
        this.commnetPic = commnetPic;
    }

    public CommentInfo(String userName, String userHeader, String commentValue, String goodsAttr,String evaluateDate) {
        this.userName = userName;
        this.userHeader = userHeader;
        this.commentValue = commentValue;
        this.goodsAttr = goodsAttr;
        this.evaluateDate = evaluateDate;
    }

    public CommentInfo(String userName, String userHeader, String commentValue, String goodsAttr,String evaluateDate,String buyDate) {
        this.userName = userName;
        this.userHeader = userHeader;
        this.commentValue = commentValue;
        this.goodsAttr = goodsAttr;
        this.evaluateDate = evaluateDate;
        this.buyDate = buyDate;
    }

    public CommentInfo() {
    }


}
