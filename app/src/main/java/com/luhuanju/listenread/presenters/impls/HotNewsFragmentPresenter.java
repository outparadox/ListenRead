package com.luhuanju.listenread.presenters.impls;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import com.luhuanju.listenread.models.IHotNewsFragmentModel;
import com.luhuanju.listenread.models.impls.HotNewsFragmentModel;
import com.luhuanju.listenread.presenters.IHotNewsFragmentPresenter;
import com.luhuanju.listenread.uis.IHotNewsFragmentVu;

public class HotNewsFragmentPresenter implements IHotNewsFragmentPresenter {
    private IHotNewsFragmentModel mIHotNewsFragmentModel = null;
    private FragmentActivity mHomeActivity = null;
    private IHotNewsFragmentVu mIHotNewsFragmentVu;


    public HotNewsFragmentPresenter(FragmentActivity activity, IHotNewsFragmentVu hotNewsFragmentVu) {
        mIHotNewsFragmentModel = mIHotNewsFragmentModel != null ? mIHotNewsFragmentModel : new HotNewsFragmentModel();
        mHomeActivity = mHomeActivity != null ? mHomeActivity : activity;
        mIHotNewsFragmentVu = mIHotNewsFragmentVu != null ? mIHotNewsFragmentVu : hotNewsFragmentVu;
    }


    @Override
    public <T> void onShowCarouseOnP(Activity activity) {

    }

    @Override
    public <T> void onShowDataOnP(Activity activity, ListView listView) {
        mIHotNewsFragmentVu.onShowData(mIHotNewsFragmentModel.onShowDataOnM(mHomeActivity, listView));
    }

    @Override
    public void baseStart() {

    }

    @Override
    public void baseFinish() {

    }
}
