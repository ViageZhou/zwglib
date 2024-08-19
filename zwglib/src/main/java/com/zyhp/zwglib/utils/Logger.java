package com.zyhp.zwglib.utils;

import android.util.Log;

/**
 * Created by ZhouWengong on 2024/8/7.
 */
public class Logger {
    private static final String TAG_DEBUG = "App_Debug";
    private static final String TAG_KERNEL = "App_Kernel";
    private static final String TAG_ERROR = "App_Error";

    private Logger() {
    }

    private static String appendMsg(String classTag) {
        return "[" + classTag + "]";
    }

    public static void d(String classTag, String msg) {
        Log.d(TAG_DEBUG, appendMsg(classTag) + msg);
    }

    public static void k(String classTag, String msg) {
        Log.i(TAG_KERNEL, appendMsg(classTag) + msg);
    }

    public static void e(String classTag, String methodName, Exception e) {
        Log.e(TAG_ERROR, appendMsg(classTag) + appendMsg(methodName) + e.getMessage());
    }

    public static void e(String classTag, String msg) {
        Log.e(TAG_ERROR, appendMsg(classTag) + msg);
    }


}
