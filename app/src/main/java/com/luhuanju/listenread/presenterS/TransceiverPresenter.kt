package com.luhuanju.listenread.presenters

import com.luhuanju.listenread.base.IRemoteCallback
import com.luhuanju.listenread.contracts.ITransceiverContract
import com.luhuanju.listenread.remote.ITransceiverModel
import com.luhuanju.listenread.remote.impls.TransceiverModel

/**
 * Created by huanjulu on 16/8/17.
 */

class TransceiverPresenter(iTransceiverVu: ITransceiverContract.ITransceiverVu) : ITransceiverContract.ITransceiverPresenter {


    internal var mITransceiverVu: ITransceiverContract.ITransceiverVu? = null

    internal var mITransceiverModel: ITransceiverModel? = null;


    init {

        this.mITransceiverVu = iTransceiverVu;

        this.mITransceiverModel = TransceiverModel()

        mITransceiverVu!!.onSetPresenter(this)

    }


    override fun <T> onRequestInP(t: T) {

        mITransceiverModel!!.onRequestDataInM<Any>(object : IRemoteCallback {
            override fun <T : Any?> onlyRemoteDataSucess(t: T) {
                mITransceiverVu!!.onShowDataInV(t)
            }

            override fun <T : Any?> onlyRemoteDataFailed(t: T) {
            }


        })
    }
}