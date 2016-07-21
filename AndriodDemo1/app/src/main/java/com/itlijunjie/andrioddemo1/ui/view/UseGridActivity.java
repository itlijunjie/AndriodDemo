package com.itlijunjie.andrioddemo1.ui.view;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.dataset.bean.UserHeader;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_grid);
        setTitle("GridView使用");

        GridView gridView = (GridView) findViewById(R.id.gridView);
        if (gridView != null) {
            gridView.setAdapter(new MyAdapter());
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Logger.d("点击第" + position + "个元素！");
                }
            });
        }
    }

    class MyAdapter extends BaseAdapter {

        private List<UserHeader> list = new ArrayList<UserHeader>(Arrays.asList(
                new UserHeader("http://f.hiphotos.baidu.com/image/pic/item/060828381f30e924bd73bbdf48086e061c95f70c.jpg", "sss"),
                new UserHeader("http://msnphoto.eastday.com/slideshow/20071019_3/images/01101173.jpg", "aaaaa"),
                new UserHeader("http://img3.100bt.com/upload/ttq/20131011/1381489733269_middle.jpg", "bbbbbb"),
                new UserHeader("http://pic8.58cdn.com.cn/p1/big/n_t01cac993909418008910c.jpg", "ccccccc"),
                new UserHeader("http://ww2.sinaimg.cn/bmiddle/e1baf646jw1ekoi191xsij20c00bata7.jpg", "fafavxzcvre"),
                new UserHeader("http://img5.duitang.com/uploads/item/201509/14/20150914083125_4WGc3.jpeg", "jhhgkghjkhjkg"),
                new UserHeader("http://i3.sinaimg.cn/gm/o/n/2009-01-11/U2408P115T9D291741F167DT20090111104747_c.jpg", "dfdfafasfa"),
                new UserHeader("http://img2.imgtn.bdimg.com/it/u=97547402,3718445442&fm=21&gp=0.jpg", "11111122"),
                new UserHeader("http://img.weixinyidu.com/160126/6bcb07aa.jpg", "3434343"),
                new UserHeader("http://img2.ph.126.net/6xJDdHQwi4-e7tktRTo5Yg==/2561422288084197182.jpg", "87787878"),
                new UserHeader("http://img2.imgtn.bdimg.com/it/u=1652489784,4173843522&fm=21&gp=0.jpg", "4f4edswqsx"),
                new UserHeader("http://img8.ph.126.net/XwW_q-XUBDk3D4Nhf_lBGQ==/2579718161570395668.jpg", "23454545"),
                new UserHeader("http://h.hiphotos.baidu.com/image/pic/item/a9d3fd1f4134970af7d8c21592cad1c8a7865d65.jpg", "jhkgjgjk"),
                new UserHeader("http://g.hiphotos.baidu.com/image/pic/item/b812c8fcc3cec3fd8afedc4ed188d43f869427cc.jpg", "cvxcvxfefwew"),
                new UserHeader("http://e.hiphotos.baidu.com/image/pic/item/738b4710b912c8fcb7338df6fb039245d78821cc.jpg", "r34gsdsfe"),
                new UserHeader("http://e.hiphotos.baidu.com/image/pic/item/b17eca8065380cd785f7d9d6a644ad345982811b.jpg", "12458776543"),
                new UserHeader("http://d.hiphotos.baidu.com/image/pic/item/9213b07eca8065381f03df2890dda144ad34821b.jpg", "llklklkjlhjl"),
                new UserHeader("http://f.hiphotos.baidu.com/image/pic/item/342ac65c10385343f626fc1a9413b07eca80881b.jpg", "lkjhgfds"),
                new UserHeader("http://b.hiphotos.baidu.com/image/pic/item/d31b0ef41bd5ad6e5c5c1fd186cb39dbb6fd3c67.jpg", "2scfrqaxcggtr"),
                new UserHeader("http://a.hiphotos.baidu.com/image/pic/item/38dbb6fd5266d01681bce513902bd40735fa3567.jpg", "54321dbrtes"),
                new UserHeader("http://g.hiphotos.baidu.com/imgad/pic/item/023b5bb5c9ea15cec0e68e76b1003af33a87b241.jpg", "ytrewqscvgg"),
                new UserHeader("http://img4q.duitang.com/uploads/item/201507/20/20150720125648_wn4YE.thumb.224_0.jpeg", "43212345t"),
                new UserHeader("http://wenwen.soso.com/p/20120324/20120324152918-1472773887.jpg", "lkkkrrrfvvcv"),
                new UserHeader("http://p4.gexing.com/touxiang/20121013/1656/50792cb396fdf_200x200_3.jpg", ";[]p][p[]p][p")
        ));


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.indexOf(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                // 使用View的对象itemView与R.layout.item关联
                convertView = UseGridActivity.this.getLayoutInflater().inflate(R.layout.usegrid_item, null);
                // 设置Tag
                convertView.setTag(convertView);
            }
            // 通过findViewById()方法实例R.layout.item内各组件
            ImageView imageView = null;
            TextView textView = null;
            imageView = (ImageView) convertView.findViewById(R.id.imageView);
            textView = (TextView) convertView.findViewById(R.id.textView);
            UserHeader userHeader = list.get(position);

            Picasso.with(UseGridActivity.this).load(userHeader.getImage()).into(imageView);

            textView.setText(userHeader.getText());

            return convertView;
        }
    }
}
