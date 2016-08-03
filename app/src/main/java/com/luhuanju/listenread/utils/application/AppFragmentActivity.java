package com.luhuanju.listenread.utils.application;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 * Author: huanjulu on 16/8/3
 * to: 
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

public class AppFragmentActivity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
