package com.itlijunjie.andrioddemo1.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.itlijunjie.andrioddemo1.R;

public class UseTweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_tween_animation);
        setTitle("补间动画");
        Button btn = (Button) findViewById(R.id.translate);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.scale);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.rotate);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.alpha);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.set);
        btn.setOnClickListener(this);
        imgShow = (ImageView) findViewById(R.id.animation_image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.translate: {
                translate();
                break;
            }
            case R.id.scale: {
                scale();
                break;
            }
            case R.id.rotate: {
                rotate();
                break;
            }
            case R.id.alpha: {
                alpha();
                break;
            }
            case R.id.set: {
                set();
                break;
            }
            default: {

            }
        }
    }

    private void translate() {
//        Animation translateAnimation=new TranslateAnimation(0, 100, 0, 0);
//
//        translateAnimation.setDuration(3000);//设置动画持续时间为3秒
//
//        translateAnimation.setInterpolator(this, android.R.anim.cycle_interpolator);//设置动画插入器
//
//        translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//
//        imgShow.startAnimation(translateAnimation);
//        第二步：加载xml动画文件并将其设置到指定的View上

        Animation translateAnimation2 = AnimationUtils.loadAnimation(this, R.anim.translate);//加载Xml文件中的动画

        imgShow.startAnimation(translateAnimation2);
    }

    private void scale() {
//        //方式一通过代码的方式定义缩放动画
//        Animation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 1.0f, 1.0f);
//
//        scaleAnimation.setDuration(2000);//设置动画持续时间为3秒
//
//        scaleAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//
//        scaleAnimation.setRepeatCount(3);
//
//        imgShow.startAnimation(scaleAnimation);
        Animation scaleAnimation2 = AnimationUtils.loadAnimation(this, R.anim.scale);//加载Xml文件中的动画
        imgShow.startAnimation(scaleAnimation2);
    }

    private void rotate() {
//        Animation rotateAnimation=new RotateAnimation(0, 45);
//
//        rotateAnimation.setDuration(3000);//设置动画持续时间为3秒
//
//        rotateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//
//        imgShow.startAnimation(rotateAnimation);
        Animation rotateAnimation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);//加载Xml文件中的动画

        imgShow.startAnimation(rotateAnimation2);
    }

    private void alpha() {
        //方式一通过代码的方式定义透明度动画
        Animation alphaAnimation = new AlphaAnimation(1, (float) 0.1);
        //设置动画持续时间为3秒
        alphaAnimation.setDuration(3000);
        //设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
        alphaAnimation.setFillAfter(true);
        imgShow.startAnimation(alphaAnimation);
//        //方式二通过在xml中定义旋转动画
//        Animation rotateAnimation2= AnimationUtils.loadAnimation(this, R.anim.alpha);//加载Xml文件中的动画
//        imgShow.startAnimation(rotateAnimation2);
    }

    private void set() {
//        //方式一通过代码的方式定义动画集
//
//        AnimationSet animationSet=new AnimationSet(true);//定义一个动画集，并设定所有的动画使用一个动画插入其
//
//        Animation translateAnimation2=AnimationUtils.loadAnimation(this, R.anim.translate);//加载Xml文件中的动画
//
//        Animation alphaAnimation2=AnimationUtils.loadAnimation(this, R.anim.alpha);//加载Xml文件中的动画
//
//        Animation rotateAnimation2=AnimationUtils.loadAnimation(this, R.anim.rotate);//加载Xml文件中的动画
//
//        Animation scaleAnimation2=AnimationUtils.loadAnimation(this, R.anim.scale);//加载Xml文件中的动画
//
//        animationSet.addAnimation(translateAnimation2);
//
//        animationSet.addAnimation(alphaAnimation2);
//
//        animationSet.addAnimation(rotateAnimation2);
//
//        animationSet.addAnimation(scaleAnimation2);
//
//        animationSet.setInterpolator(this, android.R.anim.anticipate_interpolator);
//
//        imgShow.startAnimation(animationSet);

        AnimationSet animationSet2=(AnimationSet) AnimationUtils.loadAnimation(this, R.anim.animset);
        imgShow.startAnimation(animationSet2);
    }
}
