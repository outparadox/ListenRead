package com.luhuanju.listenread.utils

/**
 * Created by huanjulu on 16/8/17.
 */
interface KThreadPool<t : Runnable> {
    open abstract fun excute(T: t)

    open abstract fun shutdown()

    open abstract fun addWorkers(num: Int)

    open abstract fun removeWorker(num: Int)

    open abstract fun getWorkerSize(): Int

}