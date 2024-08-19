package com.zyhp.zwglib.utils;

/**
 * Created by ZhouWengong on 2024/7/29.
 */
public class Singleton {
    public static final String TAG = Singleton.class.getSimpleName();

    private static class Holder {
        private final static Singleton HOLDER = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Holder.HOLDER;
    }



}

