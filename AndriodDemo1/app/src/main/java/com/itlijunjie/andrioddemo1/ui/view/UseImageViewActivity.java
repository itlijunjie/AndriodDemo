package com.itlijunjie.andrioddemo1.ui.view;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.itlijunjie.andrioddemo1.R;
import com.itlijunjie.andrioddemo1.ui.MainActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

public class UseImageViewActivity extends AppCompatActivity {
    private DisplayImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_image_view);
        this.setTitle("ImageView使用");
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
// 使用DisplayImageOptions.Builder()创建DisplayImageOptions
//        options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.checkbox_checked)          // 设置图片下载期间显示的图片
//                .showImageForEmptyUri(R.drawable.checkbox_checked)  // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageOnFail(R.drawable.checkbox_checked)       // 设置图片加载或解码过程中发生错误显示的图片
//                .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
//                .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
////                .displayer(new CircleBitmapDisplayer(50))  // 设置成圆角图片
//                .build();                                   // 创建配置过得DisplayImageOption对象
//        ImageLoader imageLoader = ImageLoader.getInstance();
//        String url = "http://f.hiphotos.baidu.com/image/pic/item/060828381f30e924bd73bbdf48086e061c95f70c.jpg";
//        imageLoader.displayImage(url, imageView, options);
        Picasso.with(this).load("http://f.hiphotos.baidu.com/image/pic/item/060828381f30e924bd73bbdf48086e061c95f70c.jpg").into(imageView);
    }
}
