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

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.luhuanju.listenread.R;
import com.luhuanju.listenread.contracts.IHotNewsFragmenrContract;
import com.luhuanju.listenread.entity.HotNewsCarousEntity;
import com.luhuanju.listenread.entity.HotNewsEntity;
import com.luhuanju.listenread.presenters.HotNewsFragmentPresenter;
import com.luhuanju.listenread.uis.adapters.HotNewsDataAdapter;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotNewsFragment extends Fragment implements IHotNewsFragmenrContract.IHotNewstVu, CircleRefreshLayout.OnCircleRefreshListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.hotnews_recy)
    RecyclerView mShowDataRecy;
    @BindView(R.id.hotnews_slider)
    SliderLayout mCarouseSlider;


    private String mData[];
    private CircleRefreshLayout mRefreshLayout;
    private IHotNewsFragmenrContract.IHomeNewsPresenter mIHotNewsFragmentPresenter = null;
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
        if(hotNewsCarousEntities==null) return;
        if (mCarouseSlider.getTag() == null) {
            for (HotNewsCarousEntity hotNewsCarousEntity : hotNewsCarousEntities) {
                TextSliderView textSliderView = new TextSliderView(getActivity());
                textSliderView
                        .description(hotNewsCarousEntity.getTitle())
//                        .image(hotNewsCarousEntity.getImgsrc())
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this);
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra", hotNewsCarousEntity.getTitle());

                mCarouseSlider.addSlider(textSliderView);
            }
            mCarouseSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
            mCarouseSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mCarouseSlider.setCustomAnimation(new DescriptionAnimation());
            mCarouseSlider.setDuration(4000);
            mCarouseSlider.addOnPageChangeListener(this);
            mCarouseSlider.setTag(hotNewsCarousEntities.size());
        }


    }

    @Override
    public void onShowData(List<HotNewsEntity> hotNewsEntities) {
        if (hotNewsEntities != null) {
            mData = new String[hotNewsEntities.size()];
            for (int m = 0; m < hotNewsEntities.size(); m++) {
                mData[m] = hotNewsEntities.get(m).getTitle();
            }
            mHotNewsEntities.addAll(hotNewsEntities);
            mHotNewsDataAdapter.refreshData(mHotNewsEntities);
        }
    }

    @Override
    public void onStop() {
        mCarouseSlider.stopAutoCycle();
        super.onStop();
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


    }

    /**
     * 初始化界面相关数据
     *
     * @param view
     */
    private void initData(View view) {
        ButterKnife.bind(this, view);
        new HotNewsFragmentPresenter(this);
        mHotNewsDataAdapter = new HotNewsDataAdapter(getActivity(), mHotNewsEntities);
        mShowDataRecy.setAdapter(mHotNewsDataAdapter);
        mShowDataRecy.setLayoutManager(mLayoutManager);
        mIHotNewsFragmentPresenter.onShowCarouseOnP(getActivity());
        mIHotNewsFragmentPresenter.onShowDataOnP(getActivity());


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public <T> void onSetPresenter(T t) {
        this.mIHotNewsFragmentPresenter = (HotNewsFragmentPresenter) t;
    }
}
