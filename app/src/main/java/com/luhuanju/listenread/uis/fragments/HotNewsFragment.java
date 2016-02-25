package com.luhuanju.listenread.uis.fragments;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * 热点新闻Fragment
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.uis.IHotNewsFragmentVu;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import butterknife.ButterKnife;

public class HotNewsFragment extends Fragment implements IHotNewsFragmentVu {
    //    @InjectView(R.id.hotnews_refresh)
    CircleRefreshLayout mRefreshLayout;
//    @InjectView(R.id.hotnews_recy)
//    RecyclerView mShowDataRecy;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hotnews, null);
        mRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.hotnews_refresh);
        ButterKnife.inject(this, view);
        initUisCallBack();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onShowCarouse() {

    }

    @Override
    public void onShowData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    void initUisCallBack() {
        mRefreshLayout.setOnRefreshListener(new CircleRefreshLayout.OnCircleRefreshListener() {
            @Override
            public void completeRefresh() {

            }

            @Override
            public void refreshing() {

            }
        });


    }


}
