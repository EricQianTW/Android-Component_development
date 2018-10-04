package com.ericshenn.test;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.roomdb.bean.SearchHistory;
import com.ericshenn.roomdb.dao.SearchHistoryDao;
import com.ericshenn.roomdb.database.SearchHistoryDatabase;
import com.ericshenn.test.romm.UserDao;

import java.util.List;

/**
 * Created by pnt_t on 2018/2/7.
 */
@Route(path = "/test/room")
public class RoomActivity extends BaseActivity {

    private TextView tvAdd, tvDel, tvGet, tvMain;

    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_act);

        tvAdd = findViewById(R.id.tv_add);
        tvGet = findViewById(R.id.tv_get);
        tvDel = findViewById(R.id.tv_delete);
        tvMain = findViewById(R.id.tv_main);

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SearchHistoryDatabase searchHistoryDB = Room.databaseBuilder(getApplicationContext(), SearchHistoryDatabase.class, "searchhistory").build();
                        SearchHistoryDao searchHistoryDao = searchHistoryDB.getSearchHistoryDao();

                        SearchHistory searchHistory = new SearchHistory();
                        searchHistory.historyItem = "fsdfsdfs";
                        searchHistory.updateTime = System.currentTimeMillis();

                        searchHistoryDao.insertUser(searchHistory);

//                        UserDatabase mUserDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "users").build();
//                        UserDao mUserDao = mUserDatabase.getUserDao();
//
//                        Log.d(TAG, "开始写入数据...");
//                        writeDatabase(mUserDao, "张三", 18);
//                        writeDatabase(mUserDao, "李四", 19);
//                        Log.d(TAG, "写入数据库完毕.");
                    }
                }).start();
            }
        });

        tvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SearchHistoryDatabase searchHistoryDB = Room.databaseBuilder(getApplicationContext(), SearchHistoryDatabase.class, "searchhistory").build();
                        SearchHistoryDao searchHistoryDao = searchHistoryDB.getSearchHistoryDao();

                        List<SearchHistory> history = searchHistoryDao.getAllSearchHistory();
                        String temp = "";

                        for (SearchHistory searchHistory : history) {
                            temp += searchHistory.historyItem;
                        }

                        final String finalTemp = temp;
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                tvMain.setText(finalTemp);
                            }
                        });
//                        new Handler().post(new Runnable() {
//                            @Override
//                            public void run() {
//                                tvMain.setText(finalTemp);
//                            }
//                        });
//                        UserDatabase mUserDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "users").build();
//                        UserDao mUserDao = mUserDatabase.getUserDao();
//                        readDatabase(mUserDao);
                    }
                }).start();
            }
        });

        tvDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

//    class MyHandler extends Handler{
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            tvMain.setText(msg.getData().get("a").toString());
//        }
//    }

    private void readDatabase(UserDao dao) {
        Log.d(TAG, "读数据库...");
//        List<User> users = dao.getAllUsers();
//        for (User u : users) {
//            Log.d(TAG, u.id + "," + u.name + "," + u.age + "," + u.updateTime);
//            ToastUtils.showShort(u.id + "," + u.name + "," + u.age + "," + u.updateTime);
//        }
//        final String temp = users.get(0).id + "," + users.get(0).name + "," + users.get(0).age + "," + users.get(0).updateTime;
//        ToastUtils.showShort(users.get(0).id + "," + users.get(0).name + "," + users.get(0).age + "," + users.get(0).updateTime);
//        tvMain.setText(users.get(0).id + "," + users.get(0).name + "," + users.get(0).age + "," + users.get(0).updateTime);
//        Message msg = new Message();
//        Bundle data = new Bundle();
//        data.putString("a",temp);
//        msg.setData(data);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
//                tvMain.setText(temp);
            }
        });
        Log.d(TAG, "读数据库完毕.");
    }

//    private void writeDatabase(UserDao dao, String name, int age) {
//        User user = new User();
//        user.name = name;
//        user.age = age;
//        user.updateTime = System.currentTimeMillis();
//        dao.insertUser(user);
//    }
//
//    private void updateUser(UserDao dao) {
//        Log.d(TAG, "更新数据库...");
//        User u = new User();
//        u.id = 2;
//        u.name = "赵五";
//        u.age = 20;
//        u.updateTime = System.currentTimeMillis();
//        dao.updateUser(u);
//        Log.d(TAG, "更新数据库完毕.");
//    }
//
//    private void deleteUser(UserDao dao, int id) {
//        Log.d(TAG, "删除数据库...");
//        User u = new User();
//        u.id = id;
//        dao.deleteUser(u);
//        Log.d(TAG, "删除数据库完毕.");
//    }
}
