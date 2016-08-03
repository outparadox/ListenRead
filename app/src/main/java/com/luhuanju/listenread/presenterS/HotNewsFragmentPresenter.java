package com.luhuanju.listenread.presenters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;

import com.luhuanju.listenread.contracts.IHotNewsFragmenrContract;
import com.luhuanju.listenread.remote.IHotNewsFragmentModel;
import com.luhuanju.listenread.remote.impls.HotNewsFragmentModel;

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
        mIHotNewsFragmentVu.onShowCarouse(mIHotNewsFragmentModel.onShowCarouseOnM());

    }

    @Override
    public <T> void onShowDataOnP(Activity activity) {
        mIHotNewsFragmentVu.onShowData(mIHotNewsFragmentModel.onShowDataOnM());
    }


    @Override
    public void baseStart() {

    }

    @Override
    public void baseFinish() {

    }
}
