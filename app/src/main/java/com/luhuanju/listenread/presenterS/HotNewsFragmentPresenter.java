package com.luhuanju.listenread.presenters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;

import com.luhuanju.listenread.base.IRemoteCallback;
import com.luhuanju.listenread.contracts.IHotNewsFragmenrContract;
import com.luhuanju.listenread.entity.HotNewsWrap;
import com.luhuanju.listenread.remote.IHotNewsFragmentModel;
import com.luhuanju.listenread.remote.impls.HotNewsFragmentModel;

import java.util.List;

public class HotNewsFragmentPresenter implements IHotNewsFragmenrContract.IHomeNewsPresenter {
    private IHotNewsFragmentModel mIHotNewsFragmentModel = null;
    private IHotNewsFragmenrContract.IHotNewstVu mIHotNewsFragmentVu;


    public HotNewsFragmentPresenter(IHotNewsFragmenrContract.IHotNewstVu hotNewsFragmentVu) {
        mIHotNewsFragmentModel = mIHotNewsFragmentModel != null ? mIHotNewsFragmentModel : new HotNewsFragmentModel();
        mIHotNewsFragmentVu = mIHotNewsFragmentVu != null ? mIHotNewsFragmentVu : hotNewsFragmentVu;
        mIHotNewsFragmentVu.onSetPresenter(this);

    }


    @Override
    public <T> void onShowCarouseOnP(Activity activity) {
        mIHotNewsFragmentModel.onShowCarouseOnM(new IRemoteCallback() {
            @Override
            public <T> void onlyRemoteDataSucess(T t) {
                mIHotNewsFragmentVu.onShowCarouse((List<HotNewsWrap.DataEntity.ArticleEntity>) t);
            }

            @Override
            public <T> void onlyRemoteDataFailed(T t) {

            }
        });

    }

    @Override
    public <T> void onShowDataOnP(Activity activity, int page) {
        mIHotNewsFragmentModel.onShowDataOnM(new IRemoteCallback() {
            @Override
            public <T> void onlyRemoteDataSucess(T t) {
                mIHotNewsFragmentVu.onShowData((List<HotNewsWrap.DataEntity.ArticleEntity>) t);

            }

            @Override
            public <T> void onlyRemoteDataFailed(T t) {

            }
        }, page);
    }


    @Override
    public void baseStart() {

    }

    @Override
    public void baseFinish() {

    }
}
