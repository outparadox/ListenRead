package com.luhuanju.listenread.base

/**
 * Created by huanjulu on 16/8/11.
 */

open interface IRetrofitCallback<T> {


    /**
     * retrofit is success
     */
    open abstract fun onlyRetrofitSucess(t: T)

    /**
     * retrofit in error failed
     */
    open abstract fun onlyRetrofitError()

}
