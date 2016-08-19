package com.luhuanju.listenread.uis.activitys

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.widget.LinearLayout
import co.mobiwise.library.MusicPlayerView
import com.google.gson.Gson
import com.luhuanju.listenread.R
import com.luhuanju.listenread.base.BaseActivity
import com.luhuanju.listenread.entity.TransreveiverEntity
import com.luhuanju.listenread.uis.fragments.KTransceiverFragment
import com.luhuanju.listenread.utils.views.BlurredUtil
import com.orhanobut.logger.Logger
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.uiThread
import java.net.URL

/**
 * Created by huanjulu on 16/8/19.
 */

class TransceiverActivity : BaseActivity() {

    override val mContentLayoutResouredId = R.layout.activity_transceiver

    var mTransceiverView: MusicPlayerView  ? = null

    var mTransceiverBg: LinearLayout ? = null

    override fun setUp() {

        super<BaseActivity>.setUp()

        mTransceiverView = findViewById(R.id.transceiver_view) as MusicPlayerView
        mTransceiverBg = findViewById(R.id.transceiver_lily) as LinearLayout
        if (intent.getStringExtra(KTransceiverFragment.KEY) != null) {
            val gsons = Gson().fromJson(intent.getStringExtra(KTransceiverFragment.KEY), TransreveiverEntity::class.java)
            Logger.d(gsons.image)
            async() {
                val result = BitmapFactory.decodeByteArray(URL(gsons.image).readBytes(), 0, URL(gsons.image).readBytes().size)
                uiThread {
                    mTransceiverBg!!.background = BitmapDrawable(BlurredUtil.BoxBlurFilter(result))
                }
            }
            mTransceiverView!!.setCoverURL(gsons.image)
        }
    }
}
