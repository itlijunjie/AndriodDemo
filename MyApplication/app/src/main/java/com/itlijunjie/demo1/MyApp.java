package com.itlijunjie.demo1;

import android.app.Application;

/**
 * Created by ljj on 15/12/25.
 */
public class MyApp extends Application {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setName("张三");
    }
}
