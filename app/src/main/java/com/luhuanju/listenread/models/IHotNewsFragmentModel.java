package com.luhuanju.listenread.models;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import com.luhuanju.listenread.entity.HotNewsEntity;

import java.util.List;

/**
 * Created by luhuanju on 16/2/25.
 */
public interface IHotNewsFragmentModel {

    public abstract <T> void onShowCarouseOnM(Activity activity);

    public abstract <T> List<HotNewsEntity> onShowDataOnM(FragmentActivity activity,ListView listView);
}
