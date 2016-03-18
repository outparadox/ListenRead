package com.luhuanju.listenread.models;

import android.app.Activity;

/**
 * Created by luhuanju on 16/2/25.
 */
public interface IHotNewsFragmentModel {

    public abstract <T> void onShowCarouseOnM(Activity activity);

    public abstract <T> void onShowDataOnM(Activity activity);
}
