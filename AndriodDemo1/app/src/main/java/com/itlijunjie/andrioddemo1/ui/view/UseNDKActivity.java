package com.itlijunjie.andrioddemo1.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ndk.NDKTest;

//参考http://my.oschina.net/zhouzhenBlog/blog/648125
public class UseNDKActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_ndk);
        TextView tv = (TextView) findViewById(R.id.textView);
        NDKTest ndk = new NDKTest();
        tv.setText(ndk.getString());
    }
}
