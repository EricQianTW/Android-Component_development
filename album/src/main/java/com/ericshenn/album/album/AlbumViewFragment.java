package com.ericshenn.album.album;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ericshenn.album.R;
import com.ericshenn.album.photo.PhotoViewActivity;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.bean.AlbumInfo;
import com.ericshenn.baselibrary.utils.IntentUtils;
import com.ericshenn.baselibrary.utils.ScreenUtils;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.baselibrary.view.pacificadapter.VerticalItemDecoration;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class AlbumViewFragment extends BaseFragment implements AlbumViewContract.View, EasyPermissions.PermissionCallbacks {

    private TextView tvCancel;
    private TextView tvCommit;
    private TextView tvBack;
    private android.support.v7.widget.RecyclerView rvItem;

    private RecyclerAdapter<AlbumInfo> rvItemAdapter;

    private List<AlbumInfo> albumInfoList = new ArrayList<>();

    private int choseCount = 0;

    public final static int RC_FILE_PERM = 125;

    private int maxCount = 1;

    String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    public int setLayoutId() {
        return R.layout.albumviews_frg;
    }

    @Override
    protected void initView() throws Exception {
        tvCancel = layoutView.findViewById(R.id.tv_cancel);
        tvBack = layoutView.findViewById(R.id.tv_back);
        tvCommit = layoutView.findViewById(R.id.tv_commit);
        rvItem = layoutView.findViewById(R.id.rv_item);

        rvItem.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        rvItem.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
        rvItem.addItemDecoration(new VerticalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());
    }

    @Override
    protected void initParame() throws Exception {
        super.initParame();
        maxCount = getArguments().getInt(AlbumViewActivity.MAXCOUNT);
    }

    @Override
    protected void initAdapter() throws Exception {
        final int width = ScreenUtils.getScreenWidth() / 5;
        final int height = width;

        rvItemAdapter = new RecyclerAdapter<AlbumInfo>(getContext(), R.layout.album_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final AlbumInfo info) {
                final int position = helper.getAdapterPosition();
                ImageView ivItem = helper.getView(R.id.iv_item);

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
                ivItem.setLayoutParams(params);
                File result = new File(info.getPath());
                Glide.with(getActivity()).load(result).into(ivItem);

                final CheckBox cbItem = helper.getView(R.id.cb_item);

                cbItem.setChecked(info.isCheck());

                cbItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (!buttonView.isPressed()) {
                            return;
                        }
                        info.setCheck(isChecked);

                        if (isChecked) {
                            if (choseCount == maxCount) {
                                cbItem.setChecked(false);
                                ToastUtils.showShort("最多选择" + maxCount + "个");
                                return;
                            } else {
                                choseCount++;
                            }
                        } else {
                            choseCount--;
                        }

                        tvCommit.setText("确认(" + choseCount + ")");
                    }
                });

                helper.getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HashMap map = new HashMap();
                        map.put(PhotoViewActivity.LISTOBJ, (Serializable) albumInfoList);
                        map.put(PhotoViewActivity.COUNT, choseCount);
                        map.put(PhotoViewActivity.POSITION, position);
                        map.put(PhotoViewActivity.MAXCOUNT, maxCount);

                        IntentUtils.startFragmentForResult(AlbumViewFragment.this, getContext(), PhotoViewActivity.class, map);
                    }
                });
            }
        };
        rvItem.setAdapter(rvItemAdapter);

    }

    @Override
    protected void initAction() throws Exception {
        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                List<String> temp = new ArrayList<>();
                for (AlbumInfo albumInfo : albumInfoList) {
                    if (albumInfo.isCheck()) {
                        temp.add(albumInfo.getPath());
                    }
                }
                intent.putExtra("urls", (Serializable) temp);
                getActivity().setResult(1, intent);
                getActivity().finish();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    protected void initData() throws Exception {
        filePermission();
    }

    public List<AlbumInfo> getSystemPhotoList(Context context) throws Exception {
        List<AlbumInfo> result = new ArrayList<AlbumInfo>();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(uri, null, null, null, MediaStore.Images.Media.DATE_ADDED + " desc");
        if (cursor == null || cursor.getCount() <= 0) return null;
        while (cursor.moveToNext()) {
            int index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String path = cursor.getString(index);
            File file = new File(path);
            if (file.exists()) {
                result.add(new AlbumInfo(path, false));
                Log.i(TAG, path);
            }
        }

        return result;
    }

    @AfterPermissionGranted(RC_FILE_PERM)
    public void filePermission() throws Exception {
        if (EasyPermissions.hasPermissions(getContext(), perms)) {
            getLocationAlbum();
        } else {
            EasyPermissions.requestPermissions(this, "必要的权限.",
                    RC_FILE_PERM, perms);
        }
    }

    private void getLocationAlbum() throws Exception {
        albumInfoList = getSystemPhotoList(getContext());
        rvItemAdapter.addAll(albumInfoList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 2) {
            albumInfoList.clear();
            albumInfoList.addAll((List<AlbumInfo>) data.getSerializableExtra(PhotoViewActivity.LISTOBJ));
            rvItemAdapter.replaceAll(albumInfoList);
            choseCount = data.getIntExtra(PhotoViewActivity.COUNT, 0);
            tvCommit.setText("确认(" + choseCount + ")");
        } else if (requestCode == 1 && resultCode == 1) {
            albumInfoList.clear();
            albumInfoList.addAll((List<AlbumInfo>) data.getSerializableExtra(PhotoViewActivity.LISTOBJ));

            Intent intent = new Intent();
            List<String> temp = new ArrayList<>();
            for (AlbumInfo albumInfo : albumInfoList) {
                if (albumInfo.isCheck()) {
                    temp.add(albumInfo.getPath());
                }
            }
            intent.putExtra("urls", (Serializable) temp);
            getActivity().setResult(1, intent);
            getActivity().finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {
            getLocationAlbum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }
}