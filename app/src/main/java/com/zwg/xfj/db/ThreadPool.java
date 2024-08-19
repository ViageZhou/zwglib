package com.zwg.xfj.db;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZhouWengong on 2023/3/29.
 */
public class ThreadPool {

    public static final String TAG = ThreadPool.class.getSimpleName();

    private static class Holder {
        private static final ThreadPool HOLDER = new ThreadPool();
    }

    private ThreadPool() {
        mExecutorService = Executors.newCachedThreadPool();
    }

    private final ExecutorService mExecutorService;

    public static void execute(Runnable command) {
        Holder.HOLDER.mExecutorService.execute(command);
    }

}
