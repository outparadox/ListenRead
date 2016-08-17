package com.luhuanju.listenread.uis.adapters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.entity.HotNewsWrap;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotNewsDataAdapter extends RecyclerView.Adapter<HotNewsDataAdapter.HotNewsDataViewHolder> {


    private Context mContext;
    private List<HotNewsWrap.DataEntity.ArticleEntity> mHotNewsEntities;

    public HotNewsDataAdapter(Context context, List<HotNewsWrap.DataEntity.ArticleEntity> hotNewsEntities) {
        this.mContext = context;
        this.mHotNewsEntities = hotNewsEntities;

    }

    public void refreshData(List<HotNewsWrap.DataEntity.ArticleEntity> hotNewsEntities) {
        Log.d("TAG", "refreshData");
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
        hotNewsDataViewHolder.hotnewsSource.setText(mHotNewsEntities.get(position).getAuthor());
        hotNewsDataViewHolder.hotnewsTitle.setText(mHotNewsEntities.get(position).getTitle());
        if (mHotNewsEntities.get(position).getImg() != null && !mHotNewsEntities.get(position).getImg().equals("")) {
            Picasso.with(mContext).load(mHotNewsEntities.get(position).getImg()).into(hotNewsDataViewHolder.hotnewsIma);
        }


    }

    @Override
    public int getItemCount() {
        return mHotNewsEntities.size();
    }

    class HotNewsDataViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hotnews_ima)
        RoundedImageView hotnewsIma;
        @BindView(R.id.hotnews_title)
        TextView hotnewsTitle;
        @BindView(R.id.hotnews_source)
        TextView hotnewsSource;
        @BindView(R.id.rl_product_wrap)
        RelativeLayout rlProductWrap;

        public HotNewsDataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
