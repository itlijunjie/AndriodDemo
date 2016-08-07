package com.itlijunjie.andrioddemo1.ndk;

/**
 * Created by ljj on 8/7/16.
 */
public class NDKTest {

    static {
        System.loadLibrary("MyJniLib");
    }

    public native String getString();
}

