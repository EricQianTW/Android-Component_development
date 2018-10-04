package com.ericshenn.baselibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;

@SuppressLint("HandlerLeak")
public class AMapUtils implements AMapLocationListener {
	
	private AMapLocationClient mLocationClient = null;
	private AMapLocationClientOption mLocationOption = null;
	private AMapLocation mAMapLocation = null;
	private Context mContext;
	
	/**
	 * 逆地址编码，GPS优先,持续定位与否
	 */
	private boolean mNeedAddress,mGpsFirst,mOnceSearch;
	/**
	 * 时间间隔
	 */
	private Long mTime;
	/**
	 *  开始定位
	 */
	public final static int MSG_LOCATION_START = 0;
	/**
	 * 定位完成
	 */
	public final static int MSG_LOCATION_FINISH = 1;
	/**
	 * 停止定位
	 */
	public final static int MSG_LOCATION_STOP= 2;
	
	public AMapUtils(Context context, boolean needAdress, boolean gpsFirst, boolean onceSearch){
		mContext = context;
		mNeedAddress = needAdress;
		mGpsFirst = gpsFirst;
		mOnceSearch = onceSearch;
	}
	
	public AMapUtils(Context context, boolean needAdress, boolean gpsFirst, boolean onceSearch, Long time){
		mContext = context;
		mNeedAddress = needAdress;
		mGpsFirst = gpsFirst;
		mOnceSearch = onceSearch;
		mTime = time;
	}
	
	public void init(){
		mLocationClient = new AMapLocationClient(mContext.getApplicationContext());
		mLocationOption = new AMapLocationClientOption();
		// 设置定位模式为高精度模式
		mLocationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
		// 设置定位监听
		mLocationClient.setLocationListener(this);
		
		initOption();
		// 设置定位参数
		mLocationClient.setLocationOption(mLocationOption);
		// 启动定位
		mLocationClient.startLocation();
		mHandler.sendEmptyMessage(MSG_LOCATION_START);
	}
	
	// 根据控件的选择，重新设置定位参数
	private void initOption() {
		// 设置是否需要显示地址信息
		mLocationOption.setNeedAddress(mNeedAddress);
		/**
		 * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
		 * 注意：只有在高精度模式下的单次定位有效，其他方式无效
		 */
		mLocationOption.setGpsFirst(mGpsFirst);
		mLocationOption.setOnceLocation(mOnceSearch);
		if (mTime != null) {
			// 设置发送定位请求的时间间隔,最小值为2000，如果小于2000，按照2000算
			mLocationOption.setInterval(mTime);
		}
	}

	@Override
	public void onLocationChanged(AMapLocation loc) {
		if (null != loc) {
			Message msg = mHandler.obtainMessage();
			msg.obj = loc;
			msg.what = MSG_LOCATION_FINISH;
			mHandler.sendMessage(msg);
		}
	}
	
	Handler mHandler = new Handler() {
		public void dispatchMessage(Message msg) {
			switch (msg.what) {
			//开始定位
			case MSG_LOCATION_START:
				break;
			// 定位完成
			case MSG_LOCATION_FINISH:
				mAMapLocation = (AMapLocation) msg.obj;
				if(mOnGetLocationListen != null){
					mOnGetLocationListen.GetLocationListening(mAMapLocation);
				}
				break;
			//停止定位
			case MSG_LOCATION_STOP:
				break;
			default:
				break;
			}
		};
	};

	public AMapLocation getAMapLocation() {
		return mAMapLocation;
	}
	
	public void destroyLocation() {
		if (null != mLocationClient) {
			/**
			 * 如果AMapLocationClient是在当前Activity实例化的，
			 * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
			 */
			mLocationClient.onDestroy();
			mLocationClient = null;
			mLocationOption = null;
		}
	}

	public interface OnGetLocationListening{
		void GetLocationListening(AMapLocation aMapLocation);
	}

	OnGetLocationListening mOnGetLocationListen=null;

	public void setOnGetLocationListen(OnGetLocationListening e){
		mOnGetLocationListen=e;
	}
}
