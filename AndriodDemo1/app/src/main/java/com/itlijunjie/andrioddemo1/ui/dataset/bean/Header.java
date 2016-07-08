package com.itlijunjie.andrioddemo1.ui.dataset.bean;

/**
 * Created by ljj on 16/7/7.
 */
public class Header {
    private String image;//头像链接
    private String text;//名字

    public Header (String url, String name) {
        image = url;
        text = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return super.toString() + "image: " + this.image + "text: " + this.text;
    }
}
