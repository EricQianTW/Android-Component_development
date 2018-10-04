package com.ericshenn.mine.bean;

import com.ericshenn.baselibrary.base.Message;
import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/1/19.
 */

public class IconInfo extends Message {
    @Expose
    private String content;
    @Expose
    private String iconUrl;
    @Expose
    private String clickUrl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public IconInfo(String content, String iconUrl, String clickUrl) {
        this.content = content;
        this.iconUrl = iconUrl;
        this.clickUrl = clickUrl;
    }

    public IconInfo() {
    }
}
