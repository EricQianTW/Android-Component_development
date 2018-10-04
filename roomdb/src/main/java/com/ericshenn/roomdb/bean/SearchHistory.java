package com.ericshenn.roomdb.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by pnt_t on 2018/2/8.
 */

@Entity(tableName = "t_searchhistory")
public class SearchHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "historyItem")
    public String historyItem;

    @ColumnInfo(name = "updateTime")
    public long updateTime;
}
