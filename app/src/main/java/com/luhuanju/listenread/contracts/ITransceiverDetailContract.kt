package com.luhuanju.listenread.contracts

import com.luhuanju.listenread.base.IViewVu

/**
 * Created by huanjulu on 16/8/20.
 */


interface ITransceiverDetailContract {


    interface ITransceiverDetailVu : IViewVu<ITransceiverDetailPresenter> {

        open fun <T> onShowTransciverDataOnV(t: T): Unit
    }

    interface ITransceiverDetailPresenter {


        open fun <T> onRequestTransceiverDataOnP(t: T): Unit


    }


}
