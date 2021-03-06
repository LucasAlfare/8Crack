package com.goldducks.a8crack;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class CrackService extends Service {
    private static final String TAG = CrackService.class.getCanonicalName();
    private ViewManager viewManager;
    private static CrackService runningInstance;

    public CrackService() {
        runningInstance = this;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        viewManager = ViewManager.init(getApplicationContext());
        viewManager.addViews();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
        viewManager.onConfigrationChanged();
    }

    public static Boolean isServiceRunning() {
        return runningInstance != null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        runningInstance = null;
        viewManager.removeAllViews();
        Log.d(TAG, "onDestroy: ");
    }
}
