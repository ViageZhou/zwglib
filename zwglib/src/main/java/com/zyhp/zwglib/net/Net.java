package com.zyhp.zwglib.net;

import android.util.Log;

import com.google.gson.Gson;
import com.zyhp.zwglib.utils.Logger;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by shuidi on 2023/9/12.
 */
public class Net {
    private static final String TAG = Net.class.getSimpleName();

    private static class Holder {
        public static final Net HOLDER = new Net();
    }

    private final API mApi;

    public static final String IP = "192.168.0.22";
    private static final String BASE_URL = "http://" + IP + ":8080";
//    public static final String IP = "117.33.244.253/";
//    private static final String BASE_URL = "http://" + IP;


    //Retrofit + okhttp + rxjava 网络请求
    private Net() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(10, TimeUnit.SECONDS) // 连接超时时间
                .readTimeout(30, TimeUnit.SECONDS) // 读取超时时间
                .writeTimeout(15, TimeUnit.SECONDS);// 写入超时时间

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(10000);
        dispatcher.setMaxRequestsPerHost(5000);
        builder.dispatcher(dispatcher);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(s -> Logger.d(TAG, s));
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

        mApi = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(API.class);
    }

    public static Net getInstance() {
        return Holder.HOLDER;
    }

    private <T> Function<Response<T>, T> transformer() {
        return baseModelResponse -> {
            if (baseModelResponse != null && baseModelResponse.body() != null) {
//                Log.e(TAG.toString(), "zwg----[Test][transformer]:  body() = " + baseModelResponse.body());
//                Log.e(TAG.toString(), "zwg----[Test][transformer]:  body().data = " + baseModelResponse.body().data);
                return baseModelResponse.body();
            }
            Log.e(TAG, "zwg ---->[transformer] Error: Response.body() == null.");
            return null;
        };
    }

//    public Observable<BaseModel<CardBalance>> queryCardBalance(String deviceNo, String cardNo) {
//        return queryCardBalance(deviceNo, cardNo, new ArrayList<>());
////        ArrayMap<String, String> map = new ArrayMap<>();
////        map.put("deviceNo", deviceNo);
////        map.put("cardNo", cardNo);
////        map.put("offlineRecords", "");
////        return mApi.queryCardBalance(getRequestBody(map)).map(transformer()).observeOn(AndroidSchedulers.mainThread());
//    }
//
//    public Observable<BaseModel<CardBalance>> queryCardBalance(String deviceNo, String cardNo, List<ConsumeRecord> recordLit) {
//        ArrayMap<String, Object> map = new ArrayMap<>();
//        map.put("deviceNo", deviceNo);
//        map.put("cardNo", cardNo);
//        map.put("offlineRecords", recordLit);
//        return mApi.queryCardBalance(getRequestBody(map)).map(transformer()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }
//
//    public Observable<BaseModel<ConsumeBean>> consume(String deviceNo, String cardNo, String cardRealBalance,
//                                                      String consumeAmount, String tradeTime, String onlineOrOffline) {
//        ArrayMap<String, String> map = new ArrayMap<>();
//        map.put("deviceNo", deviceNo);
//        map.put("cardNo", cardNo);
//        map.put("cardRealBalance", cardRealBalance);
//        map.put("consumeAmount", consumeAmount);
//        map.put("tradeTime", tradeTime);
//        map.put("onlineOrOffline", onlineOrOffline);
//        return mApi.consume(getRequestBody(map)).map(transformer()).observeOn(AndroidSchedulers.mainThread());
//    }
//
//    public Observable<BaseModel<List<FaceInfo>>> getPhoto(String deviceNo) {
//        ArrayMap<String, String> map = new ArrayMap<>();
//        map.put("deviceNo", deviceNo);
//        return mApi.getPhoto(getRequestBody(map)).map(transformer()).observeOn(Schedulers.io());
//    }
//
//    public Observable<BaseModel<UploadResult>> uploadRecord(List<ConsumeRecord> recordLit) {
//        return mApi.uploadRecord(getRequestBody(recordLit)).map(transformer()).observeOn(Schedulers.io());
//    }
//
//    public Observable<ResponseBody> downloadFile(String url) {
//        return mApi.downloadFile(url);
//    }
//
//    private RequestBody getRequestBody(Object o) {
//        return RequestBody.create(new Gson().toJson(o), MediaType.parse("application/json; charset=utf-8"));
//    }
//
//    private String list2Str(List<ConsumeRecord> list) {
//        return list == null ? "" : new Gson().toJsonTree(list).toString();
//    }

}
