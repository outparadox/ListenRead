package com.luhuanju.listenread.remote

import com.luhuanju.listenread.base.IRemoteCallback

/**
 * Created by huanjulu on 16/8/17.
 */

interface ITransceiverModel {

    open abstract fun <T> onRequestDataInM(callback: IRemoteCallback,page :Int)

}
