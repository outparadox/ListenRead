package com.luhuanju.listenread.apis

import android.content.Context
import android.util.Log
import com.luhuanju.listenread.utils.KCommonUtil
import com.squareup.okhttp.OkHttpClient
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.converter.GsonConverter

/**
 * Created by huanjulu on 16/8/12.
 */



object APIServiceGeneratorTest {

    val PREFIX = "/v3"
    private var authAdapter: RestAdapter? = null
    private var restAdapter: RestAdapter? = null
    private var districtAdapter: RestAdapter? = null
    private var fqlAdapter: RestAdapter? = null
    private var superStoreAdapter: RestAdapter? = null
    private var superStoreTokenAdapter: RestAdapter? = null
    private var orderAdapter: RestAdapter? = null

    fun <S> generate(APIClass: Class<S>, context: Context): S {
        Log.d("TAG", "generate Class")
        val gson = KCommonUtil.creatGson()
        if (authAdapter == null) {

            val build = RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint("http://apis.baidu.com" ).setConverter(GsonConverter(gson)).setRequestInterceptor(ApiHeadersTest(context))

            build.setClient(OkClient(OkHttpClient()))
            authAdapter = build.build()
        }
        return authAdapter!!.create<S>(APIClass)

    }
}
