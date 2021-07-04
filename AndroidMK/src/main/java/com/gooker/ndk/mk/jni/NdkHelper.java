package com.gooker.ndk.mk.jni;

public class NdkHelper {

    static {
        System.loadLibrary("hello-jni");
    }

    public static native int test();
    
}
