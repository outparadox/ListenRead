package com.luhuanju.listenread.presenters;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import com.luhuanju.listenread.contracts.IHomeActivityContract;
import com.luhuanju.listenread.remote.impls.HomeActivityModel;
import com.luhuanju.listenread.uis.activitys.HomeActivity;

public class HomeActivityPresenter implements IHomeActivityContract.IHomeActivityPresenter {
    private IHomeActivityContract.IHomeActivityVu mHomeActivityVu;
    private HomeActivityModel mHomeActivityModel;
    private HomeActivity mHomeAvtivityContext;

    public HomeActivityPresenter(IHomeActivityContract.IHomeActivityVu homeActivityVu, HomeActivity activity) {
        this.mHomeActivityVu = mHomeActivityVu != null ? mHomeActivityVu : homeActivityVu;
        this.mHomeAvtivityContext = mHomeAvtivityContext != null ? mHomeAvtivityContext : activity;
        mHomeActivityModel = mHomeActivityModel != null ? mHomeActivityModel : new HomeActivityModel();
        mHomeActivityVu.onSetPresenter(this);
    }


    @Override
    public <T> T getObjectComponentOnP(T... t) {
        mHomeActivityVu.onShowFragmentUi(mHomeActivityModel.getObjectComponentOnM(mHomeAvtivityContext));
        return null;
    }

    @Override
    public <T> T onResumeUiOnP(T... t) {
        mHomeActivityVu.onResumeUi();
        return null;
    }

    @Override
    public void baseStart() {

    }

    @Override
    public void baseFinish() {

    }


}
