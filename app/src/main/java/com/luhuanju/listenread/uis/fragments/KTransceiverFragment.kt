package com.luhuanju.listenread.uis.fragments

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.luhuanju.listenread.R
import com.luhuanju.listenread.base.BaseFragment
import com.luhuanju.listenread.contracts.ITransceiverContract
import com.luhuanju.listenread.entity.TransreveiverEntity
import com.luhuanju.listenread.presenters.TransceiverPresenter
import com.luhuanju.listenread.uis.adapters.TransceiverAdapter
import com.orhanobut.logger.Logger
import java.util.*

/**
 * Created by huanjulu on 16/8/17.
 */

class KTransceiverFragment : BaseFragment(), XRecyclerView.LoadingListener, ITransceiverContract.ITransceiverVu {


//    val rvMovie by Delegates.lazy { getRootView().findViewById()<XRecyclerView>(R.id.transceiver_recy) }

    override val mContentLayoutResourceId: Int = R.layout.fragment_transceiver

    var mTransceiverPresenter: ITransceiverContract.ITransceiverPresenter ? = null

    var mTransceiverAdapter: TransceiverAdapter? = null

    private val mHotNewsEntities = ArrayList<TransreveiverEntity>()

    companion object {

        internal var TAG = KTransceiverFragment.javaClass.toString();

        fun newInstance(): KTransceiverFragment {
            return KTransceiverFragment()
        }
    }

    init {
        Logger.d("init")
        TransceiverPresenter(this)
    }

    override fun setUpUi(view: View) {
        super<BaseFragment>.setUpUi(view)
        Logger.d("setUpUi")
        var mTransceiverRecy = view.findViewById(R.id.transceiver_recy) as XRecyclerView
        mTransceiverAdapter = TransceiverAdapter(activity,mHotNewsEntities)
        val mLayoutManager = LinearLayoutManager(activity)
        mTransceiverRecy.setAdapter(mTransceiverAdapter)
        mTransceiverRecy.setLayoutManager(mLayoutManager)
        mTransceiverPresenter!!.onRequestInP(null)
    }

    override fun onLoadMore() {
    }

    override fun onRefresh() {
    }

    override fun <T> onShowDataInV(t: T) {
        mTransceiverAdapter!!.refreshData(t as List<TransreveiverEntity>)
    }

    override fun <T : Any?> onSetPresenter(t: T) {
        this.mTransceiverPresenter = t as ITransceiverContract.ITransceiverPresenter

    }


}
