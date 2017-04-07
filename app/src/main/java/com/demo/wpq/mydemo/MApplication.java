package com.demo.wpq.mydemo;

import android.app.Application;

import com.demo.wpq.mydemo.retrofit.RetrofitManager;
import com.demo.wpq.mydemo.utils.CrashUtils;
import com.demo.wpq.mydemo.utils.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MApplication extends Application{

    private static MApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Fresco.initialize(this);
        RetrofitManager.init(this);

        Utils.init(getApplicationContext());
        CrashUtils.getInstance().init();
    }

    public static MApplication getInstance(){
        return mInstance;
    }
}
