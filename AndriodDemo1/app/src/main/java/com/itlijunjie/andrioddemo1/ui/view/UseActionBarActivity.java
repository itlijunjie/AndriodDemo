package com.itlijunjie.andrioddemo1.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.actionbar.CustomActionBarActivity1;
import com.orhanobut.logger.Logger;

public class UseActionBarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_action_bar);
        Button actionbar1 = (Button) findViewById(R.id.action_bar1);
        actionbar1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Class<?> cls = null;

        switch (v.getId()) {
            case R.id.action_bar1:{
                Logger.d("action_bar1");
                cls = CustomActionBarActivity1.class;
                break;
            }
            default:{

            }
        }



        if (cls != null) {
            intent.setClass(UseActionBarActivity.this, cls);
            UseActionBarActivity.this.startActivity(intent);
        }
    }
}
