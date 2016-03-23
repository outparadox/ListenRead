package com.luhuanju.listenread.uis;

import com.luhuanju.listenread.entity.HotNewsCarousEntity;
import com.luhuanju.listenread.entity.HotNewsEntity;

import java.util.List;

/**
 * Created by luhuanju on 16/2/18.
 */
public interface IHotNewsFragmentVu {
    public abstract void onShowCarouse(List<HotNewsCarousEntity> hotNewsCarousEntities);

    public abstract void onShowData(List<HotNewsEntity> hotNewsEntities);


}
