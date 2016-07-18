package com.itlijunjie.andrioddemo1.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itlijunjie.andrioddemo1.R;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_cycle);
        this.setTitle("Activity生命周期");
    }
}
