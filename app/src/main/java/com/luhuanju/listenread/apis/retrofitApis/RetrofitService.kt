package com.luhuan

import com.luhuanju.listenread.utils.KCommonUtil
import retrofit.RequestInterceptor
import retrofit.RestAdapter
import retrofit.converter.GsonConverter


/**
 * Created by huanjulu on 16/8/11.
 */

class RetrofitService {

    companion object {
        @JvmStatic

        fun <T : Any?> onCreatInstance(classType: Class<T>): Class<T> {
            val gsonBuilder = KCommonUtil.creatGson();
            val restBuilder = RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(GsonConverter(gsonBuilder))
                    .setRequestInterceptor(RetrofitHeader())
                    .build()
            return restBuilder.create(classType.javaClass)
        }

        class RetrofitHeader : RequestInterceptor {
            override fun intercept(request: RequestInterceptor.RequestFacade?) {
                throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
                request?.addHeader("apikey", "63193faf366d84b0fbf3341589f5c4be")
            }
        }
    }
}

