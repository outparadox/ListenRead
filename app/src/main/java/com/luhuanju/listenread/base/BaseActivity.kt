package com.luhuanju.listenread.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.ButterKnife
import com.luhuanju.listenread.R
import org.jetbrains.anko.find

/**
 * Created by huanjulu on 16/8/19.
 */

abstract class BaseActivity : AppCompatActivity() {


    abstract val mContentLayoutResouredId: Int


    val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)

        if (mContentLayoutResouredId != 0) setContentView(mContentLayoutResouredId) else creatContentView()

        if (savedInstanceState != null) handleSavedInstanceState(savedInstanceState)

        if (intent.extras != null) handleIntentBundleExtrax(intent.extras)


        ButterKnife.bind(this)

        setSupportActionBar(toolbar)

        setUp()

    }

    override fun onResume() {
        super<AppCompatActivity>.onResume()
    }


    override fun onPause() {
        super<AppCompatActivity>.onPause()
    }


    override fun onDestroy() {
        super<AppCompatActivity>.onDestroy()
    }


    open fun creatContentView(): View {
        throw UnsupportedOperationException("sorry , your layoutviewId ==0 , createContentView() must be implemented by subclasS")
    }

    open fun handleIntentBundleExtrax(bundle: Bundle) {

    }

    open fun handleSavedInstanceState(savedInstanceState: Bundle?) {

    }

    open fun setUp() {

    }

    open fun handleIntentExtrax(key: Any): String? {
        if (key is String) return intent.getStringExtra(key)
        return null

    }
}

