package com.luhuanju.listenread.uis;

import android.support.v4.app.FragmentTransaction;

/**
 * Created by luhuanju on 16/1/28.
 */
public interface IHomeActivityVu {
//    public abstract void onShowHotNewsUi();
//
//    public abstract void onShowTransceiverUi();
//
//    public abstract void onShowWeeklyUi();
//
//    public abstract void onShowSettingsUi();

    public abstract <T> void onShowFragmentUi(FragmentTransaction fragmentTransaction);


}
