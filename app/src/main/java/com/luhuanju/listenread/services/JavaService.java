package com.luhuanju.listenread.services;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 *
 * Author: huanjulu on 16/8/13 
 */

import com.luhuanju.listenread.services.apis.AuthenticationAPI;
import com.luhuanju.listenread.utils.KCommonUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JavaService {

    public static AuthenticationAPI creat() {

        Interceptor mTokenInterceptor = new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request authorised = originalRequest.newBuilder()
                        .header("apikey", "6d75980a5e9dcdd6da0f0aa0e4bb6397")
                        .build();
                return chain.proceed(authorised);
            }
        };



        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(mTokenInterceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
                .baseUrl("http://apis.baidu.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(KCommonUtil.Companion.creatGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(AuthenticationAPI.class);
    }


//    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
}
