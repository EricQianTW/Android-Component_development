package com.ericshenn.baselibrary.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class VersionMsg {

	public static int getVersionCode(Context context) {
		int code = 0;
		try {
			code = context.getPackageManager().getPackageInfo(
					"com.xcecs.mtbs", 0).versionCode;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	/**
	 * 获取版本号
	 * @return 当前应用的版本号
	 */
	public static String getVersionName(Context context) {
		String version = "";
	    try {
	        PackageManager manager = context.getPackageManager();
	        PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
	        version = info.versionName;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return version;
	}

}
