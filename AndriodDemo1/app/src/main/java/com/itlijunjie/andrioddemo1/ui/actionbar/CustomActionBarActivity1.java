package com.itlijunjie.andrioddemo1.ui.actionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.itlijunjie.andrioddemo1.R;
import com.orhanobut.logger.Logger;

/**
 * Created by ljj on 7/28/16.
 */
public class CustomActionBarActivity1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_action_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to theaction bar if it is present.
        getMenuInflater().inflate(R.menu.simple, menu);//获取menu目录下simple.xml的菜单文件
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.refresh:
                Logger.d("您点击了刷新菜单");
//                Utils.showToast(this, "您点击了刷新菜单", Toast.LENGTH_SHORT);
                return true;
            case R.id.cancle:
                Logger.d("您点击了取消菜单");
//                Utils.showToast(this, "您点击了取消菜单", Toast.LENGTH_SHORT);
                return true;
            case R.id.cancle2:
                Logger.d("您点击了删除菜单");
//                Utils.showToast(this, "您点击了删除菜单", Toast.LENGTH_SHORT);
                return true;
            case R.id.setting:
                Logger.d("您点击了设置菜单");
//                Utils.showToast(this, "您点击了设置菜单", Toast.LENGTH_SHORT);
                return true;
            case R.id.play:
                Logger.d("您点击了播放菜单");
//                Utils.showToast(this, "您点击了播放菜单", Toast.LENGTH_SHORT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
