package com.itlijunjie.andrioddemo1.ui.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.MainActivity;
import com.orhanobut.logger.Logger;

public class MyService extends Service {

    public static final String TAG = "MyService";

    private MyBinder mBinder = new MyBinder();

    public MyService() {
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate() {
        super.onCreate();
        Notification notification = new Notification(R.drawable.checkbox_checked,
                "有通知到来", System.currentTimeMillis());
        Notification.Builder builder = new Notification.Builder(this).setTicker("显示于屏幕顶端状态栏的文本")
                .setSmallIcon(R.drawable.checkbox_checked);
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        notification = (Notification) builder.setContentIntent(pendingIntent).setContentTitle("title").setContentText("text").build();
        startForeground(1, notification);
        Logger.d(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.d(TAG, "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG, "onDestroy() executed");
    }

//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class MyBinder extends Binder {

        public void startDownload() {
            Logger.d("TAG", "startDownload() executed");
            // 执行具体的下载任务
        }

    }
}
