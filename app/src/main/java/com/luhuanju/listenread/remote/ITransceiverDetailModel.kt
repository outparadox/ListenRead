package com.luhuanju.listenread.remote

import com.luhuanju.listenread.base.IRemoteCallback

/**
 * Created by huanjulu on 16/8/20.
 */

interface ITransceiverDetailModel {

    open fun <T> onRequestTransceiverDataOnM(t: T, callback: IRemoteCallback)


}
