package com.luhuanju.listenread.utils;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class AppActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject(this);

    }

    public static  void initInject(Activity activity) {
        ButterKnife.inject(activity);
    }
}
