package com.ericshenn.packagemode.index;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Xml;

import com.ericshenn.baselibrary.base.AppManager;
import com.ericshenn.baselibrary.base.BaseFragment;
import com.ericshenn.baselibrary.utils.PermissionUtils;
import com.ericshenn.baselibrary.utils.VersionMsg;
import com.ericshenn.packagemode.MainActivity;
import com.ericshenn.packagemode.R;
import com.ericshenn.packagemode.tools.ExternalDataManager;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.StringReader;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class IndexFragment extends BaseFragment implements IndexContract.View,EasyPermissions.PermissionCallbacks {

    private IndexContract.Presenter mPresenter = new IndexPresenter(this);

    private String appanme, apkName, versionName, localversionName, mUpdateText;
    private int versionCode, localversionCode;

    @Override
    public int setLayoutId() {
        return R.layout.index_frg;
    }

    @Override
    protected void initView() throws Exception {

        filePermission();

    }

    private void makeDirctory() {
        if (ExternalDataManager.ExternalDataPath() == "") {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("内存设备未准备好，无法运行");
            builder.setNegativeButton("知道了",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            AppManager.getAppManager().AppExit(getContext());
                        }
                    });
            builder.create().show();
        }
    }

    @AfterPermissionGranted(PermissionUtils.RC_FILE_PERM)
    public void filePermission() {
        if (EasyPermissions.hasPermissions(getActivity(), PermissionUtils.permsFile)) {
            doAction();
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "必要的权限.",
                    PermissionUtils.RC_FILE_PERM, PermissionUtils.permsFile);
        }
    }

    @Override
    protected void initAction() throws Exception {
    }

    @Override
    protected void initData() throws Exception {
    }

    /**
     * 生成更新文本
     *
     * @return
     */
    private StringBuffer getUpdateText() throws Exception {
        StringBuffer buffer = new StringBuffer();

        buffer.append("当前版本：");
        buffer.append(localversionName + "\n");

        buffer.append("当前版本编号：");
        buffer.append(localversionCode + "\n");

        buffer.append("发现新版本：");
        buffer.append(versionName + "\n");

        buffer.append("更新版本编号：");
        buffer.append(versionCode);

        if (mUpdateText != null) {
            buffer.append("\\n更新内容:\\n");
            buffer.append(mUpdateText);
        }

        return buffer;
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        doAction();
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void doAction() {
        makeDirctory();
        mPresenter.showCoupon("http://mm.tonggo.net/down/Update_matansalon.xml");
    }

    @Override
    public void setDownloadFileResult(boolean result) {
        if (result) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(new File(Environment
                            .getExternalStorageDirectory(), apkName)),
                    "application/vnd.android.package-archive");
            startActivity(intent);
        }
    }

    @Override
    public void setShowCouponResult(String result) {
        try {
            XmlPullParser xml = Xml.newPullParser();
            xml.setInput(new StringReader(result));
            int event = xml.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if ("appname".equals(xml.getName())) {
                            appanme = xml.nextText();
                        }
                        if ("apkName".equals(xml.getName())) {
                            apkName = xml.nextText();
                        }
                        if ("versionName".equals(xml.getName())) {
                            versionName = xml.nextText();
                        }
                        if ("versionCode".equals(xml.getName())) {
                            versionCode = Integer.parseInt(xml.nextText());
                        }
                        if ("update".equals(xml.getName())) {
                            mUpdateText = xml.nextText();
                        }
                        break;

                    default:
                        break;
                }
                event = xml.next();
            }

            localversionCode = VersionMsg.getVersionCode(getActivity());
            localversionName = VersionMsg.getVersionName(getActivity());

            if (localversionCode < versionCode) {
                StringBuffer buffer = getUpdateText();
                Dialog dialog = new AlertDialog.Builder(getContext(), AlertDialog.THEME_HOLO_LIGHT)
                        .setTitle("软件更新")
                        .setMessage((buffer).toString())
                        .setPositiveButton("更新", new DialogInterface.OnClickListener() {
                            @SuppressWarnings("static-access")
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mPresenter.downloadFile("http://mm.tonggo.net/down/" + apkName, apkName, getContext());
                            }
                        })
                        .setNegativeButton("取消更新",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        try {
                                            getActivity().finish();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).create();
                dialog.show();
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}