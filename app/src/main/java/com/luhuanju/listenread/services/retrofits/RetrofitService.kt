package com.luhuanju.listenread.services.retrofits

import com.luhuanju.listenread.utils.KCommonUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by huanjulu on 16/8/13.
 */

object RetrofitService {


    class CustomeInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain?): Response {
            val originalRequest = chain!!.request()
            val authorised = originalRequest!!.newBuilder()!!.header(CommonConfig.BASE_API_KEY, CommonConfig.BASE_API_VALUE)!!.build()
            return chain!!.proceed(authorised)
        }
    }

    fun <T> creat(classType: Class<T>): T {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).retryOnConnectionFailure(true).connectTimeout(15, TimeUnit.SECONDS).addNetworkInterceptor(CustomeInterceptor()).build()
        val retrofitAdapter = Retrofit.Builder().baseUrl(CommonConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(KCommonUtil.Companion.creatGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofitAdapter!!.create<T>(classType)
    }


}



