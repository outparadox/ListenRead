package com.luhuanju.listenread.apis.retrofitApis

import com.luhuanju.listenread.base.IRetrofitCallback
import com.luhuanju.listenread.entity.KHotNewsEntity
import retrofit.http.GET
import retrofit.http.QueryMap

/**
 * Created by huanjulu on 16/8/11.
 */

interface Api {


    @GET("http://apis.baidu.com/txapi/world/world")
    fun getNews(@QueryMap queryMap: QueryMap, retrofitData: IRetrofitCallback<KHotNewsEntity>): Unit;

}
