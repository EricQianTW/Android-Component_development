package com.ericshenn.packagemode.tools;

import android.os.Environment;

import java.io.File;

public class ExternalDataManager {

    /**
     * 项目工程存放文件主文件夹名称
     */
    public static final String PROJECT_FOLDER = "PCGM";
    public static final String PROJECT_FOLDER_PIC = "PIC";
    public static final String PROJECT_FOLDER_DATA = "DATA";
    public static final String PROJECT_FOLDER_VIDEO = "VIDEO";
    public static final String PROJECT_FOLDER_CACHE = "CACHE";

    public static final String PIC_CONTENT_UNDER_IMG = "/" + PROJECT_FOLDER + "/" + PROJECT_FOLDER_PIC + "/";
    public static final String PIC_CONTENT_UNDER_DATA = "/" + PROJECT_FOLDER + "/" + PROJECT_FOLDER_DATA + "/";
    public static final String PIC_CONTENT_UNDER_VIDEO = "/" + PROJECT_FOLDER + "/" + PROJECT_FOLDER_VIDEO + "/";
    public static final String PIC_CONTENT_UNDER_CACHE = "/" + PROJECT_FOLDER + "/" + PROJECT_FOLDER_CACHE + "/";

    // 判断SD卡中是否有NTMS/DATA VIDEO PIC目录
    // 没有的话，新建
    public static final String ExternalDataPath() {
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (sdCardExist) {
            File sd = Environment.getExternalStorageDirectory(); // 获取根目录 //

            String path = sd.getPath() + PIC_CONTENT_UNDER_DATA;
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = sd.getPath() + PIC_CONTENT_UNDER_IMG;
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = sd.getPath() + PIC_CONTENT_UNDER_VIDEO;
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = sd.getPath() + PIC_CONTENT_UNDER_CACHE;
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }

            return "1";
        } else {
            return "";
        }

    }

}
