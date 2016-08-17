package com.luhuanju.listenread.uis.activitys;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.contracts.IHomeActivityContract;
import com.luhuanju.listenread.presenters.KHomeActivityPresenter;
import com.luhuanju.listenread.utils.views.FontHelper;

import javax.net.ssl.ManagerFactoryParameters;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends FragmentActivity implements IHomeActivityContract.IHomeActivityVu {
    @BindView(R.id.tv_hotnews)
    TextView mTvHotNews;
    @BindView(R.id.tv_transceiver)
    TextView mTvTransceiver;
    @BindView(R.id.tv_weekly)
    TextView mTvWeekly;
    @BindView(R.id.tv_setting)
    TextView mTvSetting;
    @BindView(R.id.toolbar)
    Toolbar mToobar;
    private IHomeActivityContract.IHomeActivityPresenter mHomeActivityPresenter = null;
    private HomeActivityCallBack mHomeActivityCallBack = null;
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

    @Override
    public <T> void onSetPresenter(T t) {
        this.mHomeActivityPresenter = (KHomeActivityPresenter) t;
    }


    public interface HomeActivityCallBack {
        void onSelecteTabCallBack(String tabTag);
    }

    /**
     * @param homeActivityCallBack
     */
    public void setCallBackListener(HomeActivityCallBack homeActivityCallBack) {
        this.mHomeActivityCallBack = homeActivityCallBack;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initData(savedInstanceState);
        onInitToobarView(mToobar);

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
    public void onResumeUi() {
        mHomeActivityCallBack.onSelecteTabCallBack(HOT_NEWS);
        mHomeActivityPresenter.getObjectComponentOnP(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void onInitToobarView(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_back);//设置导航栏图标
    }

    private void initData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        new KHomeActivityPresenter(this, this);
        mHomeActivityPresenter.getObjectComponentOnP(this);
        FontHelper.applyIconFont(this, mTvHotNews, mTvTransceiver, mTvWeekly, mTvSetting);
        if (savedInstanceState != null) {
            mHomeActivityPresenter.onResumeUiOnP(savedInstanceState);
        }
    }


}
