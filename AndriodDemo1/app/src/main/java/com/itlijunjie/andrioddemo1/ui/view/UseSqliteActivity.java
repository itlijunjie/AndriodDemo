package com.itlijunjie.andrioddemo1.ui.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.dataset.bean.Person;
import com.orhanobut.logger.Logger;

public class UseSqliteActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_sqlite);
        this.setTitle("SQLite使用");

        //打开或创建test.db数据库
        db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS person");
        //创建person表
        db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");

        Button addBtn = (Button) this.findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("sqkite增加");
                Person person = new Person();
                person.setName("john");
                person.setAge(30);
                //插入数据
                db.execSQL("INSERT INTO person VALUES (NULL, ?, ?)", new Object[]{person.getName(), person.getAge()});
                person.setName("david");
                person.setAge(33);
                //ContentValues以键值对的形式存放数据
                ContentValues cv = new ContentValues();
                cv.put("name", person.getName());
                cv.put("age", person.getAge());
                //插入ContentValues中的数据
                db.insert("person", null, cv);
            }
        });

        Button delBtn = (Button) this.findViewById(R.id.del_btn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("sqlite删除");
                db.delete("person", "age < ?", new String[]{"35"});
            }
        });
        Button updateBtn = (Button) this.findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("sqlite修改");
                ContentValues cv = new ContentValues();
                cv.put("age", 35);
                //更新数据
                db.update("person", cv, "name = ?", new String[]{"john"});
            }
        });
        Button selectBtn = (Button) this.findViewById(R.id.select_btn);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("sqlite查找");
                Cursor c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"33"});
                while (c.moveToNext()) {
                    int _id = c.getInt(c.getColumnIndex("_id"));
                    String name = c.getString(c.getColumnIndex("name"));
                    int age = c.getInt(c.getColumnIndex("age"));
                    Logger.d("_id=>" + _id + ", name=>" + name + ", age=>" + age);
                }
                c.close();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(toString() + "onDestroy");
        db.close();
    }
}
