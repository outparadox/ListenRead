package com.luhuanju.listenread.services.apis

import com.luhuanju.listenread.entity.HotNewsWrap
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by huanjulu on 16/8/12.
 */
public interface AuthenticationAPI {
    @GET("3023/news/channel")
    fun onHotNews(@Query("id") owner: String, @Query("page") repo: Int): Call<HotNewsWrap>
}