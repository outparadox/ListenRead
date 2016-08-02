package com.luhuanju.listenread.remote.impls;/*
 * —————————————————————–
 * —————————————————————–
 * Author: luhuanju
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.luhuanju.listenread.R;
import com.luhuanju.listenread.remote.IHomeActivityModel;
import com.luhuanju.listenread.uis.activitys.HomeActivity;
import com.luhuanju.listenread.uis.fragments.HotNewsFragment;
import com.luhuanju.listenread.uis.fragments.SettingsFragment;
import com.luhuanju.listenread.uis.fragments.TransceiverFragment;
import com.luhuanju.listenread.uis.fragments.WeeklyReportFragment;

public class HomeActivityModel implements IHomeActivityModel, HomeActivity.HomeActivityCallBack {
    private FragmentManager mFragmentManager = null;
    private static final String HOT_NEWS = "hotnews";
    private static final String TRANSCEIVER = "transceiver";
    private static final String WEEKLY = "weekly";
    private static final String SETTING = "setting";
    private static String TAB_TAG = HOT_NEWS;
    private WeeklyReportFragment mWeeklyReportFragment = null;
    private HotNewsFragment mHotNewsFragment = null;
    private TransceiverFragment mTransceiverFragment = null;
    private SettingsFragment mSettingsFragment = null;


    @Override
    public FragmentTransaction getObjectComponentOnM(HomeActivity context) {
        mFragmentManager = mFragmentManager != null ? mFragmentManager : context.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        context.setCallBackListener(this);
        onHideFragment(mFragmentTransaction, mHotNewsFragment, mWeeklyReportFragment, mTransceiverFragment, mSettingsFragment);
        if (TAB_TAG.equals(WEEKLY)) {
            mWeeklyReportFragment = mWeeklyReportFragment != null ? mWeeklyReportFragment : new WeeklyReportFragment();
            isFragmentEverShow(mFragmentTransaction, mWeeklyReportFragment, WEEKLY);
        } else if (TAB_TAG.equals(HOT_NEWS)) {
            mHotNewsFragment = mHotNewsFragment != null ? mHotNewsFragment : new HotNewsFragment();
            isFragmentEverShow(mFragmentTransaction, mHotNewsFragment, HOT_NEWS);
        } else if (TAB_TAG.equals(TRANSCEIVER)) {
            mTransceiverFragment = mTransceiverFragment != null ? mTransceiverFragment : new TransceiverFragment();
            isFragmentEverShow(mFragmentTransaction, mTransceiverFragment, TRANSCEIVER);
        } else if (TAB_TAG.equals(SETTING)) {
            mSettingsFragment = mSettingsFragment != null ? mSettingsFragment : new SettingsFragment();
            isFragmentEverShow(mFragmentTransaction, mSettingsFragment, SETTING);
        }
        return mFragmentTransaction;
    }

    @Override
    public void onSelecteTabCallBack(String tabTag) {
        TAB_TAG = tabTag;
        Log.d("TAG", tabTag);
    }

    /**
     * 隐藏之前的FRAGMENT
     *
     * @param t
     * @param <T>
     */
    <T extends Fragment> void onHideFragment(FragmentTransaction fragmentTransaction, T... t) {
        for (Fragment fragment : t) {
            if (fragment != null) {
                fragmentTransaction.hide(fragment);
            }
        }
    }

    /**
     * @param t
     * @param <T>
     */
    <T extends Fragment> void isFragmentEverShow(FragmentTransaction fragmentTransaction, T t, String tag) {
        if (t.isAdded()) {
            fragmentTransaction.show(t);
        } else {
            fragmentTransaction.add(R.id.rlay_repalce, t, tag);
        }

    }
}
