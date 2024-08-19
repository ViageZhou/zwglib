package com.zwg.xfj.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;

/**
 * Created by ZhouWengong on 2024/7/24.
 */
public class DisplayHelper {
    private static final String TAG = DisplayHelper.class.getSimpleName();

    private static int screenH;
    private static int screenW;

    private static int statusBarHeight;
    private static int navigationBarHeight;

    public static void init(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenH = size.y;
        screenW = size.x;

        Resources resources = context.getResources();
        int result = 0;
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }


        int id = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        boolean hasMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        if (id > 0){
            navigationBarHeight = resources.getDimensionPixelSize(id);
        }
//        if (id > 0 && (!hasMenuKey && !hasBackKey)) {
//            navigationBarHeight = resources.getDimensionPixelSize(id);
//        }
    }

    public static void printInfo() {
        Log.e(TAG, "zwg----[printInfo]:  Screen: " + screenW + " x " + screenH);
        Log.e(TAG, "zwg----[printInfo]:  statusBarHeight: " + statusBarHeight);
        Log.e(TAG, "zwg----[printInfo]:  navigationBarHeight: " + navigationBarHeight);
    }

    public static int getScreenH() {
        return screenH;
    }

    public static int getScreenW() {
        return screenW;
    }

    public static int getStatusBarHeight() {
        return statusBarHeight;
    }

    public static int getNavigationBarHeight() {
        return navigationBarHeight;
    }
}
