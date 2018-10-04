package com.ericshenn.test;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ericshenn.baselibrary.base.BaseActivity;
import com.ericshenn.baselibrary.utils.GSONUtils;
import com.ericshenn.baselibrary.utils.TimeUtils;
import com.ericshenn.baselibrary.utils.ToastUtils;
import com.ericshenn.test.bean.TotalInfo;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Locale;

import okhttp3.Response;

/**
 * Created by pnt_t on 2018/3/13.
 */

public class CarActivity extends BaseActivity {

    private TextView tvDate, tvWeather,tvSpeech;
    private LinearLayout llMain;
    private Handler mHandler = new Handler();
    private TextToSpeech mSpeech;
    private static final String TAG_TTS = "CarActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.car_act);

        tvDate = findViewById(R.id.tv_date);
        tvWeather = findViewById(R.id.tv_weather);
        tvSpeech = findViewById(R.id.tv_speech);

        mHandler.postDelayed(r,1000);

        init();

//        llMain = findViewById(R.id.ll_main);
//        llMain.setBackground(getResources().getDrawable(R.drawable.bg_xiayu));

//        getWeatherData();
    }

    private void init() {
        speechInit();
//        btn_to_speak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = et_input.getText().toString();
//                if (TextUtils.isEmpty(text)) text = "请输入要测试的内容";
//                playTTS(text);
//            }
//        });
        tvSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playTTS("欢迎上车，今天的天气   晴");
            }
        });
    }

    /**
     * 初始化TextToSpeech，在onCreate中调用
     */
    private void speechInit() {
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
            mSpeech = null;
        }
        // 创建TTS对象
        mSpeech = new TextToSpeech(this, new TTSListener());
    }

    /**
     * 将文本用TTS播放
     *
     * @param str 播放的文本内容
     */
    private void playTTS(String str) {
        if (mSpeech == null) mSpeech = new TextToSpeech(this, new TTSListener());
        mSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null);
        Log.i(TAG_TTS, "播放语音为：" + str);
    }

    private final class TTSListener implements TextToSpeech.OnInitListener {
        @Override
        public void onInit(int status) {
            Log.e(TAG_TTS, "初始化结果：" + (status == TextToSpeech.SUCCESS));
            int result = mSpeech.setLanguage(Locale.CHINESE);
            //如果返回值为-2，说明不支持这种语言
            Log.e(TAG_TTS, "是否支持该语言：" + (result != TextToSpeech.LANG_NOT_SUPPORTED));
        }
    }

    private void getWeatherData() {
        try {
            OkHttpUtils
                    .get()
                    .url("http://tj.nineton.cn/Heart/index/all?city=CHSH000000&language=zh-chs&unit=c&aqi=city&alarm=1&key=78928e706123c1a8f1766f062bc8676b")
//                    .mediaType(MediaType.parse("application/json; charset=utf-8"))
//                    .content("")
                    .build()
                    .execute(new Callback<String>() {
                        @Override
                        public String parseNetworkResponse(Response response, int id) throws Exception {
                            return response.body().string();
                        }

                        @Override
                        public void onError(okhttp3.Call call, Exception e, int id) {
//                            Logger.e(e, "something happend");
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            System.out.println(response);
                            try {
                                TypeToken<TotalInfo> token = new TypeToken<TotalInfo>() {
                                };
                                TotalInfo dataPackage = GSONUtils.fromJson(response, token);
                                if (dataPackage.getStatus().equals("OK")) {
                                    ToastUtils.showShort(dataPackage.getStatus());
                                    tvWeather.setText(dataPackage.getWeather().get(0).getNow().getText());
                                } else {
                                    ToastUtils.showShort(dataPackage.getStatus());
                                }
                            } catch (Exception e) {
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            //do something
            tvDate.setText(TimeUtils.getNowString());

            //每隔1s循环执行run方法
            mHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onDestroy() {
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
            mSpeech = null;
        }
        super.onDestroy();
    }

}
