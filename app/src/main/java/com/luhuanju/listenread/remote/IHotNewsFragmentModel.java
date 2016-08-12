package com.luhuanju.listenread.remote;

import com.luhuanju.listenread.entity.HotNewsCarousEntity;
import com.luhuanju.listenread.entity.HotNewsEntity;

import java.util.List;

/**
 * Created by luhuanju on 16/2/25.
 */
public interface IHotNewsFragmentModel {

    public abstract <T> List<HotNewsCarousEntity> onShowCarouseOnM();

    public abstract <T> List<HotNewsEntity> onShowDataOnM() throws IllegalAccessException, InstantiationException;
}
