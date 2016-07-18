package com.itlijunjie.andrioddemo1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.view.LifeCycleActivity;
import com.itlijunjie.andrioddemo1.ui.view.UseButtonActivity;
import com.itlijunjie.andrioddemo1.ui.view.UseGridActivity;
import com.itlijunjie.andrioddemo1.ui.view.UseImageViewActivity;
import com.itlijunjie.andrioddemo1.ui.view.UseSqliteActivity;
import com.itlijunjie.andrioddemo1.ui.view.UseListActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> objects = new ArrayList<>();
        objects.add("ListView使用");
        objects.add("sqlite使用");
        objects.add("ImageView使用");
        objects.add("Button使用");
        objects.add("TextView使用");
        objects.add("GridView使用");
        objects.add("Activity生命周期");
        objects.add("Service生命周期");
        objects.add("BroadcastReceiver使用");
        objects.add("ContentProvider使用");
        objects.add("ActionBar使用");
        objects.add("Fragment使用");
        objects.add("Frame布局");
        objects.add("Linear布局");
        objects.add("Table布局");
        objects.add("Grid布局");
        objects.add("Relative布局");
        objects.add("Drawer布局");
        objects.add("SlidingPane布局");
        objects.add("Custom_include");
        objects.add("Custom_fragment");
        objects.add("Custom_requestFocus");
        objects.add("帧动画");
        objects.add("补间动画");
        objects.add("属性动画");
        objects.add("适配");
        objects.add("NDK_JNI");
        objects.add("手机功能");
        objects.add("感应器");
        objects.add("第三方分享");
        objects.add("国际化");
        objects.add("AIDL");
        objects.add("PopuWindow");
        listView = (ListView) MainActivity.this.findViewById(R.id.MyListView);
        listView.setAdapter(new ListViewAdapter(objects));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = objects.get(position);
                Logger.d(str);
                Intent intent = new Intent();
                Class<?> cls = null;
                if (str.equals("ListView使用")) {
                    cls = UseListActivity.class;
                } else if (str.equals("sqlite使用")) {
                    cls = UseSqliteActivity.class;
                } else if (str.equals("ImageView使用")) {
                    cls = UseImageViewActivity.class;
                } else if (str.equals("Button使用")) {
                    cls = UseButtonActivity.class;
                } else if (str.equals("GridView使用")) {
                    cls = UseGridActivity.class;
                } else if (str.equals("Activity生命周期")) {
                    cls = LifeCycleActivity.class;
                } else if (str.equals("Service生命周期")) {
                    cls = null;
                } else if (str.equals("BroadcastReceiver使用")) {
                    cls = null;
                } else if (str.equals("ContentProvider使用")) {
                    cls = null;
                } else if (str.equals("ActionBar使用")) {
                    cls = null;
                } else if (str.equals("Fragment使用")) {
                    cls = null;
                } else if (str.equals("Frame布局")) {
                    cls = null;
                } else if (str.equals("Linear布局")) {
                    cls = null;
                } else if (str.equals("Table布局")) {
                    cls = null;
                } else if (str.equals("Grid布局")) {
                    cls = null;
                } else if (str.equals("Relative布局")) {
                    cls = null;
                } else if (str.equals("Drawer布局")) {
                    cls = null;
                } else if (str.equals("SlidingPane布局")) {
                    cls = null;
                } else if (str.equals("Custom_include")) {
                    cls = null;
                } else if (str.equals("Custom_fragment")) {
                    cls = null;
                } else if (str.equals("Custom_requestFocus")) {
                    cls = null;
                } else if (str.equals("帧动画")) {
                    cls = null;
                } else if (str.equals("补间动画")) {
                    cls = null;
                } else if (str.equals("属性动画")) {
                    cls = null;
                } else if (str.equals("适配")) {
                    cls = null;
                } else if (str.equals("NDK_JNI")) {
                    cls = null;
                } else if (str.equals("手机功能")) {
                    cls = null;
                } else if (str.equals("感应器")) {
                    cls = null;
                } else if (str.equals("第三方分享")) {
                    cls = null;
                } else if (str.equals("国际化")) {
                    cls = null;
                } else if (str.equals("AIDL")) {
                    cls = null;
                } else if (str.equals("PopuWindow")) {
                    cls = null;
                }

                if (cls != null) {
                    intent.setClass(MainActivity.this, cls);
                    MainActivity.this.startActivity(intent);
                }
            }
        });

//        Button btn = ((Button) findViewById(R.id.button));
//        if (btn != null) {
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent();
//                    intent.setClass(MainActivity.this, UseListActivity.class);
//                    MainActivity.this.startActivity(intent);
//                }
//            });
//        }

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "aa", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ListViewAdapter extends BaseAdapter {

        private List<String> mList;

        public ListViewAdapter(List<String> objects) {
            this.mList = objects;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView == null) {
                holder = new Holder();

                // 使用View的对象itemView与R.layout.item关联
                convertView = MainActivity.this.getLayoutInflater().inflate(R.layout.mainlist_item, null);

                // 通过findViewById()方法实例R.layout.item内各组件
                holder.item = (TextView) convertView.findViewById(R.id.itemTitle);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.item.setText(mList.get(position));
            return convertView;
        }

        class Holder {
            TextView item;
        }

    }

}
