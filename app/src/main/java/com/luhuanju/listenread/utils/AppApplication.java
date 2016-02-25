package com.luhuanju.listenread.utils;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Application;
import android.content.Context;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 获取全局Context
     * @param context
     * @return
     */
    public static Application getApplication(Context context) {
        return (Application) context.getApplicationContext();
    }
}
