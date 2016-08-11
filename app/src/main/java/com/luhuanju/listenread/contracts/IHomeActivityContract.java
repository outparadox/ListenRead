package com.luhuanju.listenread.contracts;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 * Author: huanjulu on 16/8/2
 * to: 
 */

import android.support.v4.app.FragmentTransaction;

import com.luhuanju.listenread.base.IPersenter;
import com.luhuanju.listenread.base.IViewVu;

public interface IHomeActivityContract {

     interface IHomeActivityVu extends IViewVu<IHomeActivityPresenter> {

         abstract <T> void onShowFragmentUi(FragmentTransaction fragmentTransaction);

         abstract <T> void onResumeUi();
    }


     interface IHomeActivityPresenter extends IPersenter {

        public abstract <T> T getObjectComponentOnP(T... t);

        public abstract <T> T onResumeUiOnP(T... t);

    }


}
