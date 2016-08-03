package com.luhuanju.listenread.base;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 * Author: huanjulu on 16/8/2
 * to: 
 */

public interface IViewVu<T> {

    /**
     * set presenter in view
     *
     * @param t
     * @param <T>
     */

    <T> void onSetPresenter(T t);
}
