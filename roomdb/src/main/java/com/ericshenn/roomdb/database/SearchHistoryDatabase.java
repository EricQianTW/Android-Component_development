package com.ericshenn.roomdb.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ericshenn.roomdb.bean.SearchHistory;
import com.ericshenn.roomdb.dao.SearchHistoryDao;

/**
 * Created by pnt_t on 2018/2/8.
 */
@Database(entities = {SearchHistory.class}, version = 1, exportSchema = false)
public abstract class SearchHistoryDatabase extends RoomDatabase {
        public abstract SearchHistoryDao getSearchHistoryDao();
}
