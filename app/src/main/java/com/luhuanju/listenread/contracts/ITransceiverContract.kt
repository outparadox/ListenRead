package com.luhuanju.listenread.contracts

import com.luhuanju.listenread.base.IViewVu

/**
 * Created by huanjulu on 16/8/17.
 */
interface ITransceiverContract {

    interface ITransceiverVu : IViewVu<ITransceiverPresenter> {

        open abstract fun <T> onShowDataInV(t: T): Unit


    }

    interface ITransceiverPresenter {

        open abstract fun <T> onRequestInP(t: T): Unit

    }


}