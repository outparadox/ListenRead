package com.luhuanju.listenread.contracts;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 * Author: huanjulu on 16/8/3
 * to: 
 */

import android.app.Activity;

import com.luhuanju.listenread.base.IPersenter;
import com.luhuanju.listenread.base.IViewVu;
import com.luhuanju.listenread.entity.HotNewsWrap;

import retrofit2.Response;

public interface IHotNewsFragmenrContract {


    interface IHotNewstVu extends IViewVu<IHomeNewsPresenter> {

        abstract void onShowCarouse(Response<HotNewsWrap> hotNewsEntities);

        abstract <T> void onShowData(Response<HotNewsWrap> hotNewsEntities);

    }


    interface IHomeNewsPresenter extends IPersenter {


        abstract <T> void onShowCarouseOnP(Activity activity);

        abstract <T> void onShowDataOnP(Activity activity);


    }
}
