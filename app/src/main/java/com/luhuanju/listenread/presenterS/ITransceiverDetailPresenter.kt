package com.luhuanju.listenread.presenters

import com.luhuanju.listenread.base.IRemoteCallback
import com.luhuanju.listenread.contracts.ITransceiverDetailContract
import com.luhuanju.listenread.remote.impls.TransceiverDetailModel
import com.orhanobut.logger.Logger

/**
 * Created by huanjulu on 16/8/20.
 */

class ITransceiverDetailPresenter(transceiverActivity: ITransceiverDetailContract.ITransceiverDetailVu) : ITransceiverDetailContract.ITransceiverDetailPresenter {


    var transceiverActivity: ITransceiverDetailContract.ITransceiverDetailVu? = null

    var transceiverDetailModel: TransceiverDetailModel? = null

    companion object {

    }

    init {
        this.transceiverActivity = transceiverActivity

        this.transceiverDetailModel =  TransceiverDetailModel ()

        transceiverActivity.onSetPresenter(this)

    }

    override fun <T> onRequestTransceiverDataOnP(t: T) {
        transceiverDetailModel!!.onRequestTransceiverDataOnM(t,object :IRemoteCallback{
            override fun <T : Any?> onlyRemoteDataFailed(t: T) {
                Logger.d("onlyRemoteDataFailed ::")
            }

            override fun <T : Any?> onlyRemoteDataSucess(t: T) {
                Logger.d("onlyRemoteDataSucess ::")
                transceiverActivity!!.onShowTransciverDataOnV(t)
            }
        })

    }
}
