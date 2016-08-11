package com.luhuanju.listenread.presenters

/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import com.luhuanju.listenread.contracts.IHomeActivityContract
import com.luhuanju.listenread.remote.impls.HomeActivityModel
import com.luhuanju.listenread.uis.activitys.HomeActivity

class KHomeActivityPresenter(homeActivityVu: IHomeActivityContract.IHomeActivityVu, activity: HomeActivity) : IHomeActivityContract.IHomeActivityPresenter {
    private val mHomeActivityVu: IHomeActivityContract.IHomeActivityVu?
    private val mHomeActivityModel: HomeActivityModel?
    private val mHomeAvtivityContext: HomeActivity?

    init {
        this.mHomeActivityVu = homeActivityVu
        this.mHomeAvtivityContext =activity
        mHomeActivityModel =  HomeActivityModel()
        mHomeActivityVu.onSetPresenter(this)
    }


    override fun <T> getObjectComponentOnP(vararg t: T): T? {
        mHomeActivityVu!!.onShowFragmentUi<Any>(mHomeActivityModel!!.getObjectComponentOnM(mHomeAvtivityContext))
        return null
    }

    override fun <T> onResumeUiOnP(vararg t: T): T? {
        mHomeActivityVu!!.onResumeUi<Any>()
        return null
    }

    override fun baseStart() {

    }

    override fun baseFinish() {

    }


}
