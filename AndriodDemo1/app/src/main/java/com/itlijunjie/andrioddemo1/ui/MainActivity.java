package com.itlijunjie.andrioddemo1.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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
import com.itlijunjie.andrioddemo1.ui.view.UseImageViewActivity;
import com.itlijunjie.andrioddemo1.ui.view.UseSqliteActivity;
import com.itlijunjie.andrioddemo1.ui.view.UserListActivity;
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

        listView = (ListView) MainActivity.this.findViewById(R.id.MyListView);
        listView.setAdapter(new ListViewAdapter(objects));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = objects.get(position);
                Logger.d(str);
                if (str.equals("ListView使用")) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, UserListActivity.class);
                    MainActivity.this.startActivity(intent);
                } else if (str.equals("sqlite使用")) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,  UseSqliteActivity.class);
                    MainActivity.this.startActivity(intent);
                } else if (str.equals("ImageView使用")) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,  UseImageViewActivity.class);
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
//                    intent.setClass(MainActivity.this, UserListActivity.class);
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
        View[] itemViews;

        public ListViewAdapter(List<String> objects) {
            itemViews = new View[objects.size()];

            for (int i = 0; i < itemViews.length; ++i) {
                itemViews[i] = makeItemView(objects.get(i));
            }
        }

        public int getCount() {
            return itemViews.length;
        }

        public View getItem(int position) {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(String title) {
            LayoutInflater inflater = (LayoutInflater) MainActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.mainlist_item, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView titleView = (TextView) itemView.findViewById(R.id.itemTitle);
            titleView.setText(title);

            return itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }


    }

}
