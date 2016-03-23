package com.luhuanju.listenread.presenters;

import android.app.Activity;

/**
 * Created by luhuanju on 16/2/25.
 */
public interface IHotNewsFragmentPresenter extends IPersenter {
    public abstract <T> void onShowCarouseOnP(Activity activity);

    public abstract <T> void onShowDataOnP(Activity activity);

}
