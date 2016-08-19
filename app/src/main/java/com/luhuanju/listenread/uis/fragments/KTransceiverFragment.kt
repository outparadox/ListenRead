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

    var mPage = 0

    var isCurrentVisity=false

    var mTransceiverRecy: XRecyclerView? = null

    override val mContentLayoutResourceId: Int = R.layout.fragment_transceiver

    var mTransceiverPresenter: ITransceiverContract.ITransceiverPresenter ? = null

    var mTransceiverAdapter: TransceiverAdapter? = null

    private val mHotNewsEntities = ArrayList<TransreveiverEntity>()

    companion object {

        internal var TAG = KTransceiverFragment.javaClass.toString();

        internal val KEY="TRANSCEIVER_ITEM_KEY"

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
        mTransceiverRecy = view.findViewById(R.id.transceiver_recy) as XRecyclerView
        mTransceiverRecy!!.setLoadingListener(this)
        mTransceiverAdapter = TransceiverAdapter(activity, mHotNewsEntities)
        val mLayoutManager = LinearLayoutManager(activity)
        mTransceiverRecy!!.setAdapter(mTransceiverAdapter)
        mTransceiverRecy!!.setLayoutManager(mLayoutManager)
        if (isCurrentVisity) mPage = 1
        mTransceiverPresenter!!.onRequestInP(mPage)
    }

    override fun onLoadMore() {
        Logger.d("onLoadMore")
        mPage += 1
        mTransceiverPresenter!!.onRequestInP(mPage)
    }

    override fun onRefresh() {
        Logger.d("onRefresh")
        mPage = 1;
        mTransceiverPresenter!!.onRequestInP(mPage)
    }

    override fun <T> onShowDataInV(t: T) {
        mTransceiverAdapter!!.refreshData(t as List<TransreveiverEntity>)
        if (mPage == 1) mTransceiverRecy!!.refreshComplete() else mTransceiverRecy!!.loadMoreComplete()
    }

    override fun <T : Any?> onSetPresenter(t: T) {
        this.mTransceiverPresenter = t as ITransceiverContract.ITransceiverPresenter

    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Logger.d("setUserVisibleHint")
        if (getUserVisibleHint())
            isCurrentVisity = true
        else isCurrentVisity = false

    }

}
