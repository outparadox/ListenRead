package com.luhuanju.listenread.utils;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FontHelper {
    private static Application mApplication;
    private static Typeface mTypeFace;

    public static final String FONT = "fonts/Zhaimi-Medium.ttf";

    public static final String ICONFONT = "fonts/iconfont.ttf";

    private static final String TAG = "fontHelper";
    private static Map<String, Typeface> stringTypefaceMap = new HashMap<>();

    public static void applyFont(final Context context, final View root, final String fontName) {
        try {
            if (root instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) root;
                for (int i = 0; i < viewGroup.getChildCount(); i++)
                    applyFont(context, viewGroup.getChildAt(i), fontName);
            } else if (root instanceof TextView) {
                Typeface typeface = stringTypefaceMap.get(fontName);
                if (typeface == null) {
                    typeface = Typeface.createFromAsset(context.getAssets(), fontName);
                    stringTypefaceMap.put(fontName, typeface);
                }

                ((TextView) root).setTypeface(typeface);
            }
        } catch (Exception e) {
            Log.e(TAG, String.format("Error occured when trying to apply %s font for %s view", fontName, root));
            e.printStackTrace();
        }
    }

    public static void applyIconFont(Context context, TextView... textView) {

        for (TextView view : textView) {
            applyIcon(context, view);
        }

    }

    /**
     * @param context
     * @param textView
     */
    public static void applyIcon(Context context, TextView textView) {
        mApplication = (mApplication == null) ? AppApplication.getApplication(context) : mApplication;
        mTypeFace = (mTypeFace == null) ? Typeface.createFromAsset(mApplication.getAssets(), ICONFONT) : mTypeFace;
        textView.setTypeface(mTypeFace);
    }

}
