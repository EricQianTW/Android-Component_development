package com.ericshenn.album.album;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ericshenn.album.R;
import com.ericshenn.baselibrary.base.ActivityUtils;
import com.ericshenn.baselibrary.base.BaseActivity;

@Route(path = "/album/album")
public class AlbumViewActivity extends BaseActivity {

    public final static String MAXCOUNT = "maxcount";
    private AlbumViewFragment mAlbumViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_common_notitle_act);

        try {
            mAlbumViewFragment = new AlbumViewFragment();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mAlbumViewFragment, R.id.contentFrame);

            Bundle data = new Bundle();
            data.putInt(MAXCOUNT,getIntent().getIntExtra(MAXCOUNT,1));
            mAlbumViewFragment.setArguments(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}