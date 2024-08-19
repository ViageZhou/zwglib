package com.zyhp.zwglib.net;

import android.util.Log;


import com.zyhp.zwglib.utils.Logger;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by ZhouWengong on 2024/3/9.
 */
public abstract class MyObserver<T> implements io.reactivex.rxjava3.core.Observer<T> {

    private String TAG;

    public MyObserver(String TAG) {
        this.TAG = TAG;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

    @Override
    public void onError(@NonNull Throwable e) {
        e.printStackTrace();
        Logger.e(TAG, "zwg----[" + TAG + "][onError]:  " + e);
    }

    @Override
    public void onComplete() {
    }
}
