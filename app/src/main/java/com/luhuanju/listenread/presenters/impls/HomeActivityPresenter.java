package com.luhuanju.listenread.presenters.impls;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import com.luhuanju.listenread.models.impls.HomeActivityModel;
import com.luhuanju.listenread.presenters.IHomeActivtyPresenter;
import com.luhuanju.listenread.uis.IHomeActivityVu;
import com.luhuanju.listenread.uis.activitys.HomeActivity;

public class HomeActivityPresenter implements IHomeActivtyPresenter {
    private IHomeActivityVu mHomeActivityVu;
    private HomeActivityModel mHomeActivityModel;
    private HomeActivity mHomeAvtivityContext;

    public HomeActivityPresenter(IHomeActivityVu homeActivityVu, HomeActivity activity) {
        this.mHomeActivityVu = mHomeActivityVu != null ? mHomeActivityVu : homeActivityVu;
        this.mHomeAvtivityContext = mHomeAvtivityContext != null ? mHomeAvtivityContext : activity;
        mHomeActivityModel = mHomeActivityModel != null ? mHomeActivityModel : new HomeActivityModel();

    }


    @Override
    public <T> T getObjectComponentOnP(T t) {
        mHomeActivityVu.onShowFragmentUi(mHomeActivityModel.getObjectComponentOnM(mHomeAvtivityContext));
        return null;
    }

    @Override
    public void baseStart() {

    }

    @Override
    public void baseFinish() {

    }


}
