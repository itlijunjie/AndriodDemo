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
import android.widget.Toast;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.dataset.bean.UserHeader;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class UserListActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        this.setTitle("BaseAdapter for ListView");

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://192.168.1.108:8080/pt/call/json/Demo1/list";
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                if (statusCode == 200) {
                    //存储数组变量
                    List<UserHeader> objects = new ArrayList<>();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            // 获取具体的一个JSONObject对象
                            JSONObject obj = response.getJSONObject(i);
                            UserHeader header = new UserHeader();
                            header.setImage(obj.getString("image"));
                            header.setText(obj.getString("text"));
                            objects.add(header);
                            listView=(ListView)UserListActivity.this.findViewById(R.id.MyListView);
                            listView.setAdapter(new ListViewAdapter(objects));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(UserListActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(UserListActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(List<UserHeader> objects){
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

        private View makeItemView(UserHeader header) {
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
