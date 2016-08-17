package com.luhuanju.listenread.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.luhuanju.listenread.R

/**
 * Created by huanjulu on 16/8/16.
 */
class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    internal fun onInitToobarView(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.mipmap.ic_back);//设置导航栏图标
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
//        setSupportActionBar(toolbar)
//        val actionBar = supportActionBar
//        toolbar.setNavigationIcon(R.drawable.ic_)
////        actionBar.setHomeAsUpIndicator(R.drawable.ic_)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }
}