package com.luhuanju.listenread.remote.impls

import com.luhuanju.listenread.base.IRemoteCallback
import com.luhuanju.listenread.entity.TransreveiverEntity
import com.luhuanju.listenread.remote.ITransceiverModel
import com.luhuanju.listenread.services.retrofits.CommonConfig
import com.luhuanju.listenread.utils.XMLDataParseUtil
import com.orhanobut.logger.Logger
import org.jsoup.nodes.Element

/**
 * Created by huanjulu on 16/8/17.
 */


class TransceiverModel : ITransceiverModel {

    var transreveiverEntites = mutableListOf<TransreveiverEntity>()

    override fun <T> onRequestDataInM(callback: IRemoteCallback) {
        for (v in XMLDataParseUtil.onInstance().DocumentPOJO(CommonConfig.BASE_TRANSCEIVER).getElementsByClass("box")) {
            1.onSetTransceiverEntity(v)
        }
        callback.onlyRemoteDataSucess(transreveiverEntites)
    }


    internal infix fun Int.onSetTransceiverEntity(element: Element) {

        var transreceiver = TransreveiverEntity()

        transreceiver.title = element.getElementsByTag("a").attr("title")

        transreceiver.harf = element.getElementsByTag("a").attr("href")

        transreceiver.remark = element.getElementsByClass("entry").first().text().replace(">>阅读全文及试听","")

//        transreceiver.comment = element.getElementsByClass("ds-thread-count").text()//

        transreceiver.image = element.getElementsByTag("img").attr("src")//

        transreceiver.time = element.getElementsByClass("post-meta").first().text().replace("暂无评论","")//


        Logger.d("title:" + transreceiver.title + "image:" + transreceiver.image + "harf" + transreceiver.harf + "remark" +
                transreceiver.remark + "time" + transreceiver.time)
        transreveiverEntites.add(transreceiver)
    }

}