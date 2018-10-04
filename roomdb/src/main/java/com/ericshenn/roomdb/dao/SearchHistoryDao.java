package com.ericshenn.roomdb.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ericshenn.roomdb.bean.SearchHistory;

import java.util.List;

/**
 * Created by pnt_t on 2018/2/8.
 */
@Dao
public interface SearchHistoryDao {

    /**
     * 查询
     *
     * @return
     */
    @Query("SELECT * FROM t_searchhistory")
    public List<SearchHistory> getAllSearchHistory();

    /**
     * 添加
     *
     * @param users
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(SearchHistory... users);

    /**
     * 删除
     *
     * @param users
     */
    @Delete
    public void deleteUser(SearchHistory... users);
}
