package com.luhuanju.listenread.uis.activitys

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import co.mobiwise.library.MusicPlayerView
import com.google.gson.Gson
import com.luhuanju.listenread.R
import com.luhuanju.listenread.base.BaseActivity
import com.luhuanju.listenread.contracts.ITransceiverDetailContract
import com.luhuanju.listenread.entity.TransceiverDetailWrap
import com.luhuanju.listenread.entity.TransreveiverEntity
import com.luhuanju.listenread.presenters.ITransceiverDetailPresenter
import com.luhuanju.listenread.uis.adapters.TransceiverDetailAdapter
import com.luhuanju.listenread.uis.fragments.KTransceiverFragment
import com.luhuanju.listenread.utils.views.BlurredUtil
import com.orhanobut.logger.Logger
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.net.URL

/**
 * Created by huanjulu on 16/8/19.
 */

class TransceiverActivity : BaseActivity(), ITransceiverDetailContract.ITransceiverDetailVu {


    var mITransceiverDetailVu: ITransceiverDetailContract.ITransceiverDetailPresenter ? = null
    var listData=mutableListOf<String>()


    override fun <T : Any?> onSetPresenter(t: T) {

        this.mITransceiverDetailVu = t as ITransceiverDetailContract.ITransceiverDetailPresenter

    }

    override fun <T> onShowTransciverDataOnV(t: T) {
        var document: Document ? = Jsoup.parse((t as TransceiverDetailWrap).showapi_res_body!!.html)

        for (i in 1..document!!.getElementsByTag("p").size) {
            listData!!.add(document!!.getElementsByTag("p").text())
        }
//        adapter.onRefreshData(listData)
//        if (t != null) Logger.d(Jsoup.parse((t as TransceiverDetailWrap).showapi_res_body!!.html.getElementsByTag("p")) else throw ClassCastException("the Type t case Test is error")
    }

    override val mContentLayoutResouredId = R.layout.activity_transceiver

    var mTransceiverView: MusicPlayerView  ? = null

    var mTransceiverBg: LinearLayout ? = null

    var mTranseceiverDetails: RecyclerView ? = null

    var adapter =TransceiverDetailAdapter()

    override fun setUp() {

        super<BaseActivity>.setUp()

        mTransceiverView = findViewById(R.id.transceiver_view) as MusicPlayerView
        mTransceiverBg = findViewById(R.id.transceiver_lily) as LinearLayout
        mTranseceiverDetails = findViewById(R.id.transceiver_detail_recy) as RecyclerView

        mTranseceiverDetails!!.layoutManager=LinearLayoutManager(this)
        mTranseceiverDetails!!.adapter=adapter


        ITransceiverDetailPresenter(this)




        if (intent.getStringExtra(KTransceiverFragment.KEY) != null) {
            val gsons = Gson().fromJson(intent.getStringExtra(KTransceiverFragment.KEY), TransreveiverEntity::class.java)
            Logger.d(gsons.image)
            mITransceiverDetailVu!!.onRequestTransceiverDataOnP(gsons.harf)

            async() {
                val result = BitmapFactory.decodeByteArray(URL(gsons.image).readBytes(), 0, URL(gsons.image).readBytes().size)
                uiThread {
                    mTransceiverView!!.background = BitmapDrawable(BlurredUtil.BoxBlurFilter(result))
                }
            }
            mTransceiverView!!.setCoverURL(gsons.image)
        }
    }


}
