package com.itlijunjie.andrioddemo1.ui.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.orhanobut.logger.Logger;

/**
 * Created by ljj on 7/25/16.
 */
public class ThirdReceiver extends BroadcastReceiver {
    private static final String TAG = "NormalBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Logger.i(TAG, "ThirdReceiver: " + msg);
    }
}
