package com.zyhp.zwglib.net;



import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by shuidi on 2023/7/17.
 */
public interface API {

//    @ApiDoc("查询余额")
//    @POST("/machine/machine/queryCardBalanceByHS")
//    Observable<Response<BaseModel<CardBalance>>> queryCardBalance(@Body RequestBody body);
//
//    @ApiDoc("消费")
//    @POST("/machine/machine/consume")
//    Observable<Response<BaseModel<ConsumeBean>>> consume(@Body RequestBody body);
//
//    @ApiDoc("获取人脸数据")
//    @POST("/machine/machine/photo")
//    Observable<Response<BaseModel<List<FaceInfo>>>> getPhoto(@Body RequestBody body);
//
//    @ApiDoc("上传消费记录")
//    @POST("/machine/machine/offlineRecord")
//    Observable<Response<BaseModel<UploadResult>>> uploadRecord(@Body RequestBody body);

    @ApiDoc("下载图片")
    @GET
    Observable<ResponseBody> downloadFile(@Url String url);



}
