package com.ericshenn.baselibrary.bean;

import com.ericshenn.baselibrary.base.Message;
import com.google.gson.annotations.Expose;

/**
 * Created by pnt_t on 2018/1/24.
 */

public class AlbumInfo extends Message {

    @Expose
    private String path;

    @Expose
    private boolean isCheck;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public AlbumInfo(String path, boolean isCheck) {
        this.path = path;
        this.isCheck = isCheck;
    }

    public AlbumInfo() {
    }
}
