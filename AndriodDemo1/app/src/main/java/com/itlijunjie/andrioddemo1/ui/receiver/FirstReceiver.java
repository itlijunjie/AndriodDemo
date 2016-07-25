package com.itlijunjie.andrioddemo1.ui.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.orhanobut.logger.Logger;

/**
 * Created by ljj on 7/25/16.
 */
public class FirstReceiver extends BroadcastReceiver {
    private static final String TAG = "NormalBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Logger.i(TAG, "FirstReceiver: " + msg);
        //普通广播（Normal Broadcast）并不能终止继续执行，会抛出运行时
        //java.lang.RuntimeException: BroadcastReceiver trying to return result during a non-ordered broadcast
        abortBroadcast();
    }
}
