package com.itlijunjie.andrioddemo1.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itlijunjie.andrioddemo1.R;
import com.orhanobut.logger.Logger;

public class UseSqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_sqlite);
        Button addBtn = (Button) this.findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("sqkite增加");
            }
        });

        Button delBtn = (Button) this.findViewById(R.id.del_btn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("sqlite删除");
            }
        });
    }
}
