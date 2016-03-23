package com.luhuanju.listenread.uis.fragments;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * 热点新闻Fragment
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.entity.HotNewsCarousEntity;
import com.luhuanju.listenread.entity.HotNewsEntity;
import com.luhuanju.listenread.models.impls.HotNewsFragmentModel;
import com.luhuanju.listenread.presenters.IHotNewsFragmentPresenter;
import com.luhuanju.listenread.presenters.impls.HotNewsFragmentPresenter;
import com.luhuanju.listenread.uis.IHotNewsFragmentVu;
import com.luhuanju.listenread.uis.adapters.HotNewsDataAdapter;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HotNewsFragment extends Fragment implements IHotNewsFragmentVu, CircleRefreshLayout.OnCircleRefreshListener {
    CircleRefreshLayout mRefreshLayout;
    @InjectView(R.id.hotnews_recy)
    RecyclerView mShowDataRecy;

    private String mData[];

    private HotNewsFragmentModel mHotNewsFragmentModel = null;
    private IHotNewsFragmentPresenter mIHotNewsFragmentPresenter = null;
    private HotNewsDataAdapter mHotNewsDataAdapter = null;
    private List<HotNewsEntity> mHotNewsEntities = new ArrayList<>();
    private LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hotnews, null);
        initViewWidget(view);
        initData(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onShowCarouse(List<HotNewsCarousEntity> hotNewsCarousEntities) {

    }

    @Override
    public void onShowData(List<HotNewsEntity> hotNewsEntities) {
        mData = new String[hotNewsEntities.size()];
        for (int m = 0; m < hotNewsEntities.size(); m++) {
            mData[m] = hotNewsEntities.get(m).getTitle();
        }
        mHotNewsEntities.addAll(hotNewsEntities);
        mHotNewsDataAdapter.refreshData(mHotNewsEntities);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void completeRefresh() {

    }

    @Override
    public void refreshing() {

    }


    /**
     * 初始化界面相关控件
     *
     * @param view
     */
    private void initViewWidget(View view) {

        mRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.hotnews_refresh);
        view.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIHotNewsFragmentPresenter.onShowDataOnP(getActivity());
            }
        });

    }

    /**
     * 初始化界面相关数据
     *
     * @param view
     */
    private void initData(View view) {

        ButterKnife.inject(this, view);
        mHotNewsDataAdapter = new HotNewsDataAdapter(getActivity(), mHotNewsEntities);
        mShowDataRecy.setAdapter(mHotNewsDataAdapter);
        mShowDataRecy.setLayoutManager(mLayoutManager);

        mIHotNewsFragmentPresenter = mIHotNewsFragmentPresenter != null ? mIHotNewsFragmentPresenter : new HotNewsFragmentPresenter(getActivity(), this);
        mIHotNewsFragmentPresenter.onShowCarouseOnP(getActivity());
        mIHotNewsFragmentPresenter.onShowDataOnP(getActivity());


    }
}
