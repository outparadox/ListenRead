package com.luhuanju.listenread.presenters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.luhuanju.listenread.contracts.IHotNewsFragmenrContract;
import com.luhuanju.listenread.remote.IHotNewsFragmentModel;
import com.luhuanju.listenread.remote.impls.HotNewsFragmentModel;

public class HotNewsFragmentPresenter implements IHotNewsFragmenrContract.IHomeNewsPresenter {
    private IHotNewsFragmentModel mIHotNewsFragmentModel = null;
    private FragmentActivity mHomeActivity = null;
    private IHotNewsFragmenrContract.IHotNewstVu mIHotNewsFragmentVu;


    public HotNewsFragmentPresenter(FragmentActivity activity, IHotNewsFragmenrContract.IHotNewstVu hotNewsFragmentVu) {
        mIHotNewsFragmentModel = mIHotNewsFragmentModel != null ? mIHotNewsFragmentModel : new HotNewsFragmentModel();
        mHomeActivity = mHomeActivity != null ? mHomeActivity : activity;
        mIHotNewsFragmentVu = mIHotNewsFragmentVu != null ? mIHotNewsFragmentVu : hotNewsFragmentVu;
    }


    @Override
    public <T> void onShowCarouseOnP(Activity activity) {
        mIHotNewsFragmentVu.onShowCarouse(mIHotNewsFragmentModel.onShowCarouseOnM(mHomeActivity));

    }

    @Override
    public <T> void onShowDataOnP(Activity activity) {
        mIHotNewsFragmentVu.onShowData(mIHotNewsFragmentModel.onShowDataOnM(mHomeActivity));
    }


    @Override
    public void baseStart() {

    }

    @Override
    public void baseFinish() {

    }
}
