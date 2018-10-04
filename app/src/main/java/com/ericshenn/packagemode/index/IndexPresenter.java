package com.ericshenn.packagemode.index;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Xml;

import com.ericshenn.baselibrary.base.BasePresenter;
import com.ericshenn.baselibrary.utils.VersionMsg;
import com.ericshenn.packagemode.MainActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Response;

public class IndexPresenter extends BasePresenter implements IndexContract.Presenter{
    private IndexContract.View mView;

    public IndexPresenter(@NonNull IndexContract.View view){
        mView = view;
    }

    public IndexPresenter() {
    }

    @Override
    public void downloadFile(String url, String fileName, Context context) {
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("下载中 请稍后...");
        dialog.setProgressStyle(dialog.STYLE_HORIZONTAL);
        dialog.incrementProgressBy(1);
        dialog.show();

        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName)//
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        dialog.dismiss();
                        mView.setDownloadFileResult(true);
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        dialog.setProgress((int) (progress * 100));
                    }

                });
    }

    public void showCoupon(String path) {
        try {
            OkHttpUtils
                    .get()
                    .url(path)
                    .build()
                    .execute(new Callback<String>() {
                        @Override
                        public String parseNetworkResponse(Response response, int id) throws Exception {
                            return response.body().string();
                        }

                        @Override
                        public void onError(okhttp3.Call call, Exception e, int id) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            try {
                                mView.setShowCouponResult(response);
//                                XmlPullParser xml = Xml.newPullParser();
//                                xml.setInput(new StringReader(response));
//                                int event = xml.getEventType();
//                                while (event != XmlPullParser.END_DOCUMENT) {
//                                    switch (event) {
//                                        case XmlPullParser.START_TAG:
//                                            if ("appname".equals(xml.getName())) {
//                                                appanme = xml.nextText();
//                                            }
//                                            if ("apkName".equals(xml.getName())) {
//                                                apkName = xml.nextText();
//                                            }
//                                            if ("versionName".equals(xml.getName())) {
//                                                versionName = xml.nextText();
//                                            }
//                                            if ("versionCode".equals(xml.getName())) {
//                                                versionCode = Integer.parseInt(xml.nextText());
//                                            }
//                                            if ("update".equals(xml.getName())) {
//                                                mUpdateText = xml.nextText();
//                                            }
//                                            break;
//
//                                        default:
//                                            break;
//                                    }
//                                    event = xml.next();
//                                }
//
//                                localversionCode = VersionMsg.getVersionCode(getActivity());
//                                localversionName = VersionMsg.getVersionName(getActivity());
//
//                                if (localversionCode < versionCode) {
//                                    StringBuffer buffer = getUpdateText();
//                                    Dialog dialog = new AlertDialog.Builder(getContext(), AlertDialog.THEME_HOLO_LIGHT)
//                                            .setTitle("软件更新")
//                                            .setMessage((buffer).toString())
//                                            .setPositiveButton("更新", new DialogInterface.OnClickListener() {
//                                                @SuppressWarnings("static-access")
//                                                @Override
//                                                public void onClick(DialogInterface dialog, int which) {
//                                                    mPresenter.downloadFile("http://mm.tonggo.net/down/" + apkName, apkName, getContext());
//                                                }
//                                            })
//                                            .setNegativeButton("取消更新",
//                                                    new DialogInterface.OnClickListener() {
//
//                                                        @Override
//                                                        public void onClick(DialogInterface dialog,
//                                                                            int which) {
//                                                            try {
//                                                                getActivity().finish();
//                                                            } catch (Exception e) {
//                                                                e.printStackTrace();
//                                                            }
//                                                        }
//                                                    }).create();
//                                    dialog.show();
//                                } else {
//                                    new Handler().postDelayed(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Intent intent = new Intent(getActivity(), MainActivity.class);
//                                            startActivity(intent);
//                                        }
//                                    }, 1000);
//                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}