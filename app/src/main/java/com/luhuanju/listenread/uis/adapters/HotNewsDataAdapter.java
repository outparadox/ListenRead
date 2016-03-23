package com.luhuanju.listenread.uis.adapters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.entity.HotNewsEntity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HotNewsDataAdapter extends RecyclerView.Adapter<HotNewsDataAdapter.HotNewsDataViewHolder> {

    private Context mContext;
    private List<HotNewsEntity> mHotNewsEntities;

    public HotNewsDataAdapter(Context context, List<HotNewsEntity> hotNewsEntities) {
        this.mContext = context;
        this.mHotNewsEntities = hotNewsEntities;

    }

    public void refreshData(List<HotNewsEntity> hotNewsEntities) {
        this.mHotNewsEntities = hotNewsEntities;
        notifyDataSetChanged();

    }

    @Override
    public HotNewsDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HotNewsDataViewHolder hotNewsDataViewHolder = new HotNewsDataViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_hotnews, parent,
                false));
        return hotNewsDataViewHolder;
    }

    @Override
    public void onBindViewHolder(HotNewsDataViewHolder hotNewsDataViewHolder, int position) {
        hotNewsDataViewHolder.mHotNewsTitleTv.setText(mHotNewsEntities.get(position).getTitle());
        hotNewsDataViewHolder.mHotNewsTimeTv.setText(mHotNewsEntities.get(position).getTime());
        if (mHotNewsEntities.get(position).getImgsrc() != null && !mHotNewsEntities.get(position).getImgsrc().equals("")) {
            Picasso.with(mContext).load(mHotNewsEntities.get(position).getImgsrc()).into(hotNewsDataViewHolder.mHotNewsPictureIma);
        }

    }

    @Override
    public int getItemCount() {
        return mHotNewsEntities.size();
    }

    class HotNewsDataViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.hotnews_title_tv)
        TextView mHotNewsTitleTv;
        @InjectView(R.id.hotnews_time_tv)
        TextView mHotNewsTimeTv;
        @InjectView(R.id.hotnews_picture_ima)
        RoundedImageView mHotNewsPictureIma;


        public HotNewsDataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
