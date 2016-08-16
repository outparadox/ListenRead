package com.luhuanju.listenread.base;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 * Author: huanjulu on 16/8/2
 * to: 
 */

public interface IRemoteCallback {

    /**
     * when data is success from remote
     *
     * @param t
     * @param <T>
     */

    abstract <T> void onlyRemoteDataSucess(T t);

    /**
     * when data is failes from remote
     *
     * @param t
     * @param <T>
     */

    abstract <T> void onlyRemoteDataFailed(T t);
}
