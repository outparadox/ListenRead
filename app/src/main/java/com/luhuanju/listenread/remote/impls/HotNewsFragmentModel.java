package com.luhuanju.listenread.remote.impls;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 *
 *
 */

import com.luhuanju.listenread.base.IRemoteCallback;
import com.luhuanju.listenread.entity.HotNewsWrap;
import com.luhuanju.listenread.remote.IHotNewsFragmentModel;
import com.luhuanju.listenread.services.apis.AuthenticationAPI;
import com.luhuanju.listenread.services.retrofits.CommonConfig;
import com.luhuanju.listenread.services.retrofits.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotNewsFragmentModel implements IHotNewsFragmentModel {
    private HotNewsEntityPOJOCallBack mHotNewsEntityPOJOCallBack;

    public HotNewsFragmentModel() {
    }


    @Override
    public <T> void onShowCarouseOnM(final IRemoteCallback callback) {
        RetrofitService.INSTANCE.creat(AuthenticationAPI.class).onHotNews(CommonConfig.Companion.getBASE_RECOMM(), 1).enqueue(new Callback<HotNewsWrap>() {
            @Override
            public void onResponse(Call<HotNewsWrap> call, Response<HotNewsWrap> response) {
                if (response.body().getCode() != 0) return;
                for (int i = 0; i < response.body().getData().getArticle().size(); i++) {
                    if (response.body().getData().getArticle().get(i).getImg() == null || response.body().getData().getArticle().get(i).getImg().equals("")) {
                        response.body().getData().getArticle().remove(response.body().getData().getArticle().get(i));
                    }
                }
                callback.onlyRemoteDataSucess(response);
            }
            @Override
            public void onFailure(Call<HotNewsWrap> call, Throwable t) {
            }
        });
    }

    @Override
    public <T> void onShowDataOnM(final IRemoteCallback callback) {
        RetrofitService.INSTANCE.creat(AuthenticationAPI.class).onHotNews(CommonConfig.Companion.getBASE_POPULAR(), 1).enqueue(new Callback<HotNewsWrap>() {
            @Override
            public void onResponse(Call<HotNewsWrap> call, Response<HotNewsWrap> response) {
                callback.onlyRemoteDataSucess(response);

            }

            @Override
            public void onFailure(Call<HotNewsWrap> call, Throwable t) {
            }
        });
    }


    /**
     * 设计欠缺 弃用
     */
    public interface HotNewsEntityPOJOCallBack {

//        abstract void onHotNewsEntityPOJOSuccess(List<HotNewsEntity> hotNewsEntities, FragmentActivity homeActivity, ListView listView);

        abstract void onHotNewsEntityPOJOFailed();
    }

    public void setHotNewsEntityPOJOListener(HotNewsEntityPOJOCallBack hotNewsEntityPOJOCallBack) {

        mHotNewsEntityPOJOCallBack = hotNewsEntityPOJOCallBack;
    }
}
