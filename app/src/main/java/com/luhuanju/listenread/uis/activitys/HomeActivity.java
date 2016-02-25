package com.luhuanju.listenread.uis.activitys;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.presenters.IHomeActivtyPresenter;
import com.luhuanju.listenread.presenters.impls.HomeActivityPresenter;
import com.luhuanju.listenread.uis.IHomeActivityVu;
import com.luhuanju.listenread.utils.AppActivity;
import com.luhuanju.listenread.utils.FontHelper;

import butterknife.InjectView;
import butterknife.OnClick;

public class HomeActivity extends FragmentActivity implements IHomeActivityVu {
    @InjectView(R.id.tv_hotnews)
    TextView mTvHotNews;
    @InjectView(R.id.tv_transceiver)
    TextView mTvTransceiver;
    @InjectView(R.id.tv_weekly)
    TextView mTvWeekly;
    @InjectView(R.id.tv_setting)
    TextView mTvSetting;
    IHomeActivtyPresenter mHomeActivityPresenter = null;
    HomeActivityCallBack mHomeActivityCallBack;
    private static final String HOT_NEWS = "hotnews";
    private static final String TRANSCEIVER = "transceiver";
    private static final String WEEKLY = "weekly";
    private static final String SETTING = "setting";


    @OnClick(R.id.tv_hotnews)
    void onClickH() {
        mHomeActivityCallBack.onSelecteTabCallBack(HOT_NEWS);
        mHomeActivityPresenter.getObjectComponentOnP(this);
    }

    @OnClick(R.id.tv_transceiver)
    void onClickT() {
        mHomeActivityCallBack.onSelecteTabCallBack(TRANSCEIVER);
        mHomeActivityPresenter.getObjectComponentOnP(this);
    }

    @OnClick(R.id.tv_weekly)
    void onClickW() {
        mHomeActivityCallBack.onSelecteTabCallBack(WEEKLY);
        mHomeActivityPresenter.getObjectComponentOnP(this);
    }

    @OnClick(R.id.tv_setting)
    void onClickS() {
        mHomeActivityCallBack.onSelecteTabCallBack(SETTING);
        mHomeActivityPresenter.getObjectComponentOnP(this);
    }


    public interface HomeActivityCallBack {

        void onSelecteTabCallBack(String tabTag);

    }

    public void setCallBackListener(HomeActivityCallBack homeActivityCallBack) {
        this.mHomeActivityCallBack = homeActivityCallBack;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mHomeActivityPresenter = new HomeActivityPresenter(this, this);
        mHomeActivityPresenter.getObjectComponentOnP(this);
        AppActivity.initInject(this);
        FontHelper.applyIconFont(this, mTvHotNews, mTvTransceiver, mTvWeekly, mTvSetting);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public <T> void onShowFragmentUi(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
