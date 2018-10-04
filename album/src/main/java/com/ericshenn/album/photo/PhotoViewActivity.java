package com.ericshenn.album.photo;

import android.os.Bundle;

import com.ericshenn.album.R;
import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.baselibrary.bean.AlbumInfo;

import java.util.ArrayList;

public class PhotoViewActivity extends BaseActivity {

    public final static String LISTOBJ = "listobj";
    public final static String COUNT = "count";
    public final static String POSITION = "position";
    public final static String MAXCOUNT = "maxcount";

    private PhotoViewFragment photoViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_notitle_act);

        try {

            Bundle data = new Bundle();

            data.putSerializable(LISTOBJ, (ArrayList<AlbumInfo>) getIntent().getSerializableExtra(LISTOBJ));
            data.putInt(COUNT, getIntent().getIntExtra(COUNT, 0));
            data.putInt(POSITION, getIntent().getIntExtra(POSITION, 0));
            data.putInt(MAXCOUNT, getIntent().getIntExtra(MAXCOUNT, 1));

            photoViewFragment = new PhotoViewFragment();
            photoViewFragment.setArguments(data);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    photoViewFragment, R.id.contentFrame);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}