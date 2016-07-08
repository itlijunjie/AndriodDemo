package com.itlijunjie.andrioddemo1.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.dataset.bean.Header;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        List<Header> objects = new ArrayList<>();
        com.itlijunjie.andrioddemo1.ui.dataset.bean.Header header1 = new com.itlijunjie.andrioddemo1.ui.dataset.bean.Header("u1", "n1");
        com.itlijunjie.andrioddemo1.ui.dataset.bean.Header header2 = new com.itlijunjie.andrioddemo1.ui.dataset.bean.Header("u2", "n2");
        objects.add(header1);
        objects.add(header2);
        this.setTitle("BaseAdapter for ListView");
        listView=(ListView)this.findViewById(R.id.MyListView);
        listView.setAdapter(new ListViewAdapter(objects));
    }


    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(List<Header> objects){
            itemViews = new View[objects.size()];

            for (int i=0; i<itemViews.length; ++i){
                itemViews[i] = makeItemView(objects.get(i));
            }
        }

        public int getCount()   {
            return itemViews.length;
        }

        public View getItem(int position)   {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(Header header) {
            LayoutInflater inflater = (LayoutInflater)UserListActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.userlist_item, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView)itemView.findViewById(R.id.itemTitle);
            title.setText(header.getText());
            TextView text = (TextView)itemView.findViewById(R.id.itemText);
            text.setText(header.getImage());
            ImageView image = (ImageView)itemView.findViewById(R.id.itemImage);
//            image.setImageResource(R.drawa);

            return itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }
}
