package com.luhuanju.listenread.uis.fragments

import android.view.View
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.luhuanju.listenread.R
import com.luhuanju.listenread.base.BaseFragment

/**
 * Created by huanjulu on 16/8/17.
 */

class KTransceiverFragment : BaseFragment(), XRecyclerView.LoadingListener {


    override fun onLoadMore() {



    }

    override fun onRefresh() {
    }

    override val mContentLayoutResourceId: Int = R.layout.fragment_transceiver

    val mTransceiverRecy: XRecyclerView? = null


    companion object {

        internal var TAG = KTransceiverFragment.javaClass.toString();

        fun newInstance(): KTransceiverFragment {
            return KTransceiverFragment()
        }

    }


    override fun setUpUi(view: View) {
        super<BaseFragment>.setUpUi(view)


    }

}
