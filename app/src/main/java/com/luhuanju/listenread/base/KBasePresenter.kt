package com.luhuanju.listenread.base

import android.view.View

/**
 * Created by huanjulu on 16/8/11.
 */

abstract class KBasePresenter<T : View> {

    protected var view: T ? = null

    fun register(view: T) {
        this.view = view
    }

    fun unregister() {
        this.view = null
    }
}



