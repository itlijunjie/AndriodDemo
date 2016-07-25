package com.itlijunjie.andrioddemo1.ui.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.receiver.MyReceiver;

public class UseBroadcastReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_broadcast_receiver);
//        MyReceiver receiver = new MyReceiver();
//
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("android.intent.action.MY_BROADCAST");
//
//        registerReceiver(receiver, filter);

        Button button = (Button) findViewById(R.id.receiveButton);
        button.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        send(v);
    }

    private void send(View view) {
        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        intent.putExtra("msg", "hello receiver.");
        sendBroadcast(intent);
    }
}
