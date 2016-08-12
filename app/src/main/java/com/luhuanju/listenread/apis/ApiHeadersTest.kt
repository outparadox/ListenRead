package com.luhuanju.listenread.apis

import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import retrofit.RequestInterceptor

/**
 * Created by huanjulu on 16/8/12.
 */
class ApiHeadersTest(private val context: Context) : RequestInterceptor {

    override fun intercept(request: RequestInterceptor.RequestFacade) {
        request.addHeader("Accept", "application/json; charset=utf-8")
        request.addHeader("apikey", "63193faf366d84b0fbf3341589f5c4be")
        request.addHeader("User-Agent", "Android")
        request.addHeader("System-Version", Build.VERSION.RELEASE)
        request.addHeader("X-Device", Build.DEVICE)
        request.addHeader("X-Model", Build.MODEL)
        request.addHeader("uniqueID", getImei(context))
        request.addHeader("X-Product", Build.PRODUCT)
    }

    private fun getImei(context: Context): String {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.deviceId
    }
}
