package com.luhuanju.listenread.entitis;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.luhuanju.listenread.R;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import butterknife.ButterKnife;


import butterknife.InjectView;
import butterknife.OnClick;

public class TetsA extends Fragment {


    @InjectView(R.id.hotnews_slider)
    SliderLayout hotnewsSlider;
    @InjectView(R.id.hotnews_recy)
    RecyclerView hotnewsRecy;
    @InjectView(R.id.hotnews_refresh)

    CircleRefreshLayout hotnewsRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotnews, container, false);
        ButterKnife.inject(view);


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.hotnews_slider, R.id.hotnews_recy, R.id.hotnews_refresh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hotnews_slider:
                break;
            case R.id.hotnews_recy:

                break;
            case R.id.hotnews_refresh:
                break;
        }
    }
}
