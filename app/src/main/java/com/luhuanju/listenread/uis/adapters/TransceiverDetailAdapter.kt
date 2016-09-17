package com.luhuanju.listenread.uis.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luhuanju.listenread.R
import com.luhuanju.listenread.utils.application.AppApplication
import org.jetbrains.anko.find

/**
 * Created by huanjulu on 16/8/24.
 */

class TransceiverDetailAdapter : RecyclerView.Adapter<TransceiverDetailAdapter.TransceiverDetailViewHolder>() {


    private var mData: MutableList <String> ? = arrayListOf<String>()

    open fun onRefreshData(listData: MutableList <String> ?) {
        this.mData = listData
        notifyDataSetChanged()

    }


    override fun getItemCount(): Int = mData!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TransceiverDetailViewHolder {

        return TransceiverDetailAdapter.TransceiverDetailViewHolder(LayoutInflater.from(AppApplication.getApplication()).inflate(R.layout.item_transceiver_detail, parent, false))


    }

    override fun onBindViewHolder(holder: TransceiverDetailViewHolder?, position: Int) {
        holder!!.setItemData(mData!![position])
    }


    class TransceiverDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        init {

        }

        override fun onClick(v: View?) {
        }


        val contentTv = itemView.find<TextView>(R.id.tv_transceiver_detail)

        open fun setItemData(content: String) {

            contentTv.text = content
        }

    }
}
