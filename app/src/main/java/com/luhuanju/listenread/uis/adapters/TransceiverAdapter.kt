package com.luhuanju.listenread.uis.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.gson.Gson
import com.luhuanju.listenread.R
import com.luhuanju.listenread.entity.TransreveiverEntity
import com.luhuanju.listenread.uis.activitys.TransceiverActivity
import com.luhuanju.listenread.uis.fragments.KTransceiverFragment
import com.luhuanju.listenread.utils.application.AppApplication
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by huanjulu on 16/8/18.
 */

class TransceiverAdapter(var context: Context, var transceiverEntites: List<TransreveiverEntity>) : RecyclerView.Adapter<TransceiverAdapter.TransceiverViewholder>() {


    fun refreshData(transceiverEntites: List<TransreveiverEntity>) {
        this.transceiverEntites = transceiverEntites

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransceiverViewholder {

        return TransceiverViewholder(LayoutInflater.from(AppApplication.getApplication()).inflate(R.layout.item_transceiver, parent, false))
    }

    override fun getItemCount(): Int {
        return transceiverEntites.count()
    }

    override fun onBindViewHolder(holder: TransceiverViewholder?, position: Int) {
        holder!!.setItem(transceiverEntites[position], position, context)


        holder!!.transceiverItem.setOnClickListener {
            val intent = Intent(context, TransceiverActivity::class.java)
            intent.putExtra(KTransceiverFragment.KEY, Gson().toJson(transceiverEntites[position]))
            context.startActivity(intent)
        }
    }


    class TransceiverViewholder(view: View) : RecyclerView.ViewHolder(view) {

        val transceiverItem: CardView = view.find(R.id.card_transceiver_item)
        private val transceiverIma: RoundedImageView = view.find(R.id.ima_transceiver_photo)
        private val transceiverTitle: TextView = view.find(R.id.tv_transceiver_title)
        private val transceiverRemark: TextView = view.find(R.id.tv_transceiver_remark)
        private val transceiverDate: TextView = view.find(R.id.tv_transceiver_date)


        open fun setItem(transceiverEntity: TransreveiverEntity, position: Int, context: Context) {
            transceiverTitle.text = transceiverEntity.title
            transceiverRemark.text = transceiverEntity.remark
            transceiverDate.text = transceiverEntity.time
            Picasso.with(context).load(transceiverEntity.image).centerCrop().fit().into(transceiverIma)
        }
    }
}
