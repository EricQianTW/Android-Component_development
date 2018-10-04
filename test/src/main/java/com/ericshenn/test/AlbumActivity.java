package com.ericshenn.test;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ericshenn.baselibrary.utils.ScreenUtils;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.baselibrary.view.pacificadapter.VerticalItemDecoration;
import com.ericshenn.test.base.BaseTestActivity;
import com.ericshenn.test.bean.AlbumInfo;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by pnt_t on 2018/1/23.
 */

public class AlbumActivity extends BaseTestActivity implements EasyPermissions.PermissionCallbacks {

    private Button look;
    private RecyclerView rvItem;
    private RecyclerAdapter adapter;
    private ImageView image;
    private TextView tvChoosenum;

    private int choseCount = 0;

    String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    public final static int RC_FILE_PERM = 125;

    private List<AlbumInfo> albumInfoList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_act);

        look = findViewById(R.id.look);
        rvItem = findViewById(R.id.rv_item);
        image = findViewById(R.id.image);
        tvChoosenum = findViewById(R.id.tv_choosenum);

        rvItem.setLayoutManager(new GridLayoutManager(getApplicationContext(), 5));
        rvItem.addItemDecoration(new HorizontalItemDecoration
                .Builder(getApplicationContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());

        rvItem.addItemDecoration(new VerticalItemDecoration
                .Builder(getApplicationContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());

        final int width = ScreenUtils.getScreenWidth() / 5;
        final int height = width;

        adapter = new RecyclerAdapter<AlbumInfo>(getApplicationContext(), R.layout.album_adp) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, final AlbumInfo item) {
                final int position = helper.getAdapterPosition();
                ImageView ivItem = helper.getView(R.id.iv_item);

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
                ivItem.setLayoutParams(params);
                File result = new File(item.getPath());
                Glide.with(AlbumActivity.this).load(result).into(ivItem);

                CheckBox cbItem = helper.getView(R.id.cb_item);

                cbItem.setChecked(item.isCheck());

                cbItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (!buttonView.isPressed()) {
                            return;
                        }
                        item.setCheck(isChecked);

                        if (isChecked) {
                            choseCount ++;
                        } else {
                            choseCount --;
                        }

                        tvChoosenum.setText("确认(" + choseCount + ")");
                    }
                });

                helper.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();

                        intent.setClass(AlbumActivity.this, PhotoActivity.class);

                        intent.putExtra("listobj", (Serializable) albumInfoList);
                        intent.putExtra("count", choseCount);
                        intent.putExtra("position", position);

                        startActivityForResult(intent, 1);

                    }
                });
            }
        };

        rvItem.setAdapter(adapter);

        filePermission();

        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                albumInfoList = getSystemPhotoList(getApplicationContext());
                adapter.addAll(albumInfoList);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            albumInfoList.clear();

            if (requestCode == 1) {
                List<AlbumInfo> temp = (ArrayList<AlbumInfo>) data.getSerializableExtra("listobj");

                albumInfoList.addAll(temp);

                adapter.replaceAll(albumInfoList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<AlbumInfo> getSystemPhotoList(Context context) {
        List<AlbumInfo> result = new ArrayList<AlbumInfo>();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if (cursor == null || cursor.getCount() <= 0) return null; // 没有图片
        while (cursor.moveToNext()) {
            int index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String path = cursor.getString(index); // 文件地址
            File file = new File(path);
            if (file.exists()) {
                result.add(new AlbumInfo(path, false));
                Log.i(TAG, path);
            }
        }

        return result;
    }

    @AfterPermissionGranted(RC_FILE_PERM)
    public void filePermission() {
        if (EasyPermissions.hasPermissions(this, perms)) {

        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "必要的权限.",
                    RC_FILE_PERM, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
