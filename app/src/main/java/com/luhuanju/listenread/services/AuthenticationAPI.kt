
import retrofit2.http.GET
import retrofit2.http.Query

//package com.luhuanju.listenread.apis
//
//import retrofit.Callback
//import retrofit.client.Response
//import retrofit.http.GET
//import retrofit.http.Query
//
///**
// * Created by huanjulu on 16/8/12.
// */
interface AuthenticationAPI {
    @GET("/3023/news/channel")
    abstract fun getNews(@Query("id") id: String, @Query("page") page: Int)

}
