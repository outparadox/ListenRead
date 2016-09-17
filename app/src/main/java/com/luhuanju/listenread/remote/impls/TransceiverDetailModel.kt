package com.luhuanju.listenread.remote.impls

import com.luhuanju.listenread.base.IRemoteCallback
import com.luhuanju.listenread.entity.TransceiverDetailWrap
import com.luhuanju.listenread.remote.ITransceiverDetailModel
import com.luhuanju.listenread.services.apis.AuthenticationAPI
import com.luhuanju.listenread.services.retrofits.RetrofitService
import com.orhanobut.logger.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by huanjulu on 16/8/20.
 */


class TransceiverDetailModel : ITransceiverDetailModel {

    init {

    }

    override fun <T> onRequestTransceiverDataOnM(t: T, callback: IRemoteCallback) {

        RetrofitService.creat(AuthenticationAPI::class.java).onTransciverDetailData<T>(t as String).enqueue(object :Callback<TransceiverDetailWrap> {
            override fun onResponse(call: Call<TransceiverDetailWrap>?, response: Response<TransceiverDetailWrap>?) {
                Logger.d("onResponse")
                callback.onlyRemoteDataSucess(response!!.body())
            }

            override fun onFailure(call: Call<TransceiverDetailWrap>?, t: Throwable?) {
                Logger.d("onFailure")
            }

        })
    }
}