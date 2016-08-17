package com.luhuanju.listenread.remote;

import com.luhuanju.listenread.base.IRemoteCallback;

/**
 * Created by luhuanju on 16/2/25.
 */
public interface IHotNewsFragmentModel {

    public abstract <T> void onShowCarouseOnM(IRemoteCallback callback);

    public abstract <T> void onShowDataOnM(IRemoteCallback callback,int page);
}
