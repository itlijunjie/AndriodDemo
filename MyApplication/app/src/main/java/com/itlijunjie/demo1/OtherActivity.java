package com.itlijunjie.demo1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity {

    private  MyApp myApp;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        textView = (TextView)this.findViewById(R.id.msg);
        myApp = (MyApp)getApplication();
        textView.setText(myApp.getName());
    }
}
