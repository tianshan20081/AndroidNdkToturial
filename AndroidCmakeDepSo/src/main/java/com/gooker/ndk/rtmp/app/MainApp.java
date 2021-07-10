package com.gooker.ndk.rtmp.app;

import android.app.Application;
import android.content.Context;

import com.gooker.cts.app.BaseApp;

public class MainApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        BaseApp.setApp(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BaseApp.setLogTag("rtmp");
    }
}
