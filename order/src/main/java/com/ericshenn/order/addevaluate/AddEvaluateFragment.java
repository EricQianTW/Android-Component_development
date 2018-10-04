package com.ericshenn.order.addevaluate;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ericshenn.album.album.AlbumViewActivity;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.constants.Const;
import com.ericshenn.baselibrary.view.pacificadapter.HorizontalItemDecoration;
import com.ericshenn.order.R;
import com.ericshenn.order.bean.EvaluatePicInfo;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddEvaluateFragment extends BaseFragment implements AddEvaluateContract.View {

    private AddEvaluateContract.Presenter mPresenter = new AddEvaluatePresenter(this);
    private RecyclerAdapter<EvaluatePicInfo> adapter;

    private RecyclerView rvPicture;
    private EditText etContent;
    private TextView tvGoodsname, tvAddpic;
    private LinearLayout llMain;
    private String photoPath;

    @Override
    public int setLayoutId() {
        return R.layout.addevaluate_frg;
    }

    @Override
    protected void initView() throws Exception {
        llMain = layoutView.findViewById(R.id.ll_main);
        tvAddpic = layoutView.findViewById(R.id.tv_addpic);
        rvPicture = layoutView.findViewById(R.id.rv_picture);
        rvPicture.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.gray_d4)
                .sizeResId(R.dimen.height_explore_divider_1)
                .build());

        tvGoodsname = layoutView.findViewById(R.id.tv_goodsname);
        etContent = layoutView.findViewById(R.id.et_content);
        etContent.setFocusable(true);
        etContent.setFocusableInTouchMode(true);
        etContent.requestFocus();//获取焦点 光标出现
    }

    @Override
    protected void initAdapter() throws Exception {
        adapter = new RecyclerAdapter<EvaluatePicInfo>(getContext(), R.layout.addevaluate_adp) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, final EvaluatePicInfo info) {
                final int position = helper.getAdapterPosition();
                ImageView ivEvaluate = helper.getView(R.id.iv_evaluate);
                Glide.with(AddEvaluateFragment.this).load(info.getPath()).into(ivEvaluate);
                helper.setOnClickListener(R.id.iv_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adapter.removeAt(position);
                        refreshAddTv();
                    }
                });
            }
        };
        rvPicture.setAdapter(adapter);
    }

    public String getTakePhotoPath(){
        return "/PCGM/PIC/temp" + System.currentTimeMillis() + ".jpg";
    }

    @Override
    protected void initAction() throws Exception {
        tvAddpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] stringItems = {"拍照", "从相册选择"};
                final ActionSheetDialog dialog = new ActionSheetDialog(getContext(), stringItems, llMain);
                dialog.isTitleShow(false).show();

                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (position == 0) {
                            photoPath = getTakePhotoPath();
                            File file = new File(Environment
                                    .getExternalStorageDirectory(), photoPath);
                            Log.e(TAG, photoPath);
                            if (file.exists()) {
                                file.delete();
                            }
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                            startActivityForResult(intent, Const.TAKEPHOTO);
                        } else {
                            Intent intent = new Intent();
                            intent.setClassName(getActivity(), "com.ericshenn.album.album.AlbumViewActivity");
                            intent.putExtra(AlbumViewActivity.MAXCOUNT,5);
                            AddEvaluateFragment.this.startActivityForResult(intent, Const.ALBUMLIST);
                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Const.TAKEPHOTO:
                EvaluatePicInfo temp = new EvaluatePicInfo(Environment
                        .getExternalStorageDirectory() + photoPath);
                adapter.add(temp);
                break;
            case Const.ALBUMLIST:
                if (resultCode == 1) {
                    List<String> array = (List<String>) data.getSerializableExtra("urls");
                    List<EvaluatePicInfo> arrayEpI = new ArrayList<>();
                    for (String s : array) {
                        arrayEpI.add(new EvaluatePicInfo(s));
                    }
                    adapter.addAll(arrayEpI);
                }
                break;
            default:
                break;
        }
        refreshAddTv();
    }

    private void refreshAddTv() {
        int picSize = adapter.getItemCount();

        if (picSize == 0) {
            rvPicture.setVisibility(View.GONE);
        } else {
            rvPicture.setVisibility(View.VISIBLE);
            rvPicture.setLayoutManager(new GridLayoutManager(getActivity(), picSize));
        }

        if (picSize > 0) {
            tvAddpic.setText("  " + picSize + " / 5  ");
        } else {
            tvAddpic.setText("添加图片");
        }
        tvAddpic.setVisibility(picSize == 5 ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void initData() throws Exception {
        tvGoodsname.setText("SDFSDFSDFSDFSDFSDFSFDSDDFSDFSDFSDFS");
    }

}