package com.luhuanju.listenread.services.apis

import com.luhuanju.listenread.services.WeatherJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by huanjulu on 16/8/12.
 */

//
//public interface AuthenticationAPI {
//    @GET("/3023/news/channel")
////    abstract fun getNews(@Query("id") id: String, @Query("page") page: Int, callback: ResponseJava<String>)
//     fun getNews(@QueryMap  options:Map<String, Object> , callback: ResponseJava<String>) :Unit
//
//}
//
public interface AuthenticationAPI {
    @GET("3023/news/channel")
            //
//    fun getNews(@QueryMap options:Map<String, Object>) :Call<String>
//    @GET("repos/{owner}/{repo}/contributors")
    fun contributorsBySimpleGetCall(@Query("id") owner: String, @Query("page") repo: Int): Call<String>
}

interface ApiStores {
    @GET("adat/sk/{cityId}.html")
    fun getWeather(@Path("cityId") cityId: String): Call<WeatherJson>
}