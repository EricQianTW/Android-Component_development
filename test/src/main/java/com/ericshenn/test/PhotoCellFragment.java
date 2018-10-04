package com.ericshenn.test;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.test.bean.AlbumInfo;

/**
 * Created by pnt_t on 2018/1/24.
 */

public class PhotoCellFragment extends BaseFragment {

    private AlbumInfo mAlbumInfo;
    private ImageView ivItem;

    @Override
    public int setLayoutId() {
        return R.layout.photocell_frg;
    }

    public static PhotoCellFragment getInstance(AlbumInfo albumInfo) {
        PhotoCellFragment fragment = new PhotoCellFragment();
        fragment.mAlbumInfo = albumInfo;
        return fragment;
    }

    @Override
    protected void initView() throws Exception {
        super.initView();
        ivItem = layoutView.findViewById(R.id.iv_item);

        Glide.with(this).load(mAlbumInfo.getPath()).into(ivItem);

    }
}
