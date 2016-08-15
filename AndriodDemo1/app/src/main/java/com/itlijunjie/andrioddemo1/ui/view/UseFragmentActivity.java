package com.itlijunjie.andrioddemo1.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.actionbar.CustomActionBarActivity1;
import com.itlijunjie.andrioddemo1.ui.fragment.UseFragmentActivity1;
import com.orhanobut.logger.Logger;

public class UseFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_fragment);
        Button button = (Button) findViewById(R.id.fragment_button1);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.fragment_button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Class<?> cls = null;

        switch (v.getId()) {
            case R.id.fragment_button1: {
                Logger.d("fragment_button1");
                cls = UseFragmentActivity1.class;
                break;
            }
            case R.id.fragment_button2: {
                Logger.d("fragment_button2");

                break;
            }
            default: {

            }
        }

        if (cls != null) {
            intent.setClass(UseFragmentActivity.this, cls);
            UseFragmentActivity.this.startActivity(intent);
        }
    }
}
