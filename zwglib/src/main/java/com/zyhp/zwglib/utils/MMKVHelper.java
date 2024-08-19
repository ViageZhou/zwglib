package com.zyhp.zwglib.utils;

import android.content.Context;
import android.util.Log;

import com.tencent.mmkv.MMKV;

/**
 * Created by ZhouWengong on 2024/7/29.
 */
public class MMKVHelper {
    private static final String TAG = MMKVHelper.class.getSimpleName();
    private static final String KEY_ID = "key_id";
    private static MMKV mmkv;

    public static void init(Context context) {
        String rootDir = MMKV.initialize(context);
        Log.e(TAG, "MMKV: " + rootDir);
        mmkv = MMKV.defaultMMKV();
    }

    public static void saveString(String key, String value) {
        mmkv.encode(key, value);
    }

    public static String getString(String key) {
        return getString(key, "");
    }

    public static String getString(String key, String defaultValue) {
        return mmkv.decodeString(key, defaultValue);
    }

    public static int getID() {
        int i = mmkv.decodeInt(KEY_ID, 0);
        if (i > 99999999){
            i = 0;
        }
        mmkv.encode(KEY_ID, ++i);
        return i;
    }
}
