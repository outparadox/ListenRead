package com.luhuanju.listenread.utils.application;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class AppApplication extends MultiDexApplication implements Thread.UncaughtExceptionHandler {

    private static Application context;

    @Override
    public void onCreate() {

        super.onCreate();
        context = this;
    }

    /**
     * 获取全局Context
     *
     * @return
     */
    public static Context getApplication() {
        return
                context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

    }
}
