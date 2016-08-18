package com.luhuanju.listenread.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.properties.Delegates

/**
 * Created by huanjulu on 16/8/17.
 */


/**
 * BaseFragment
 */
abstract class BaseFragment : Fragment() {

    abstract val mContentLayoutResourceId: Int

    var vRoot: View by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {

        super<Fragment>.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            handleSavedInstanceState(savedInstanceState)
        }

        val args = getArguments();

        if (args != null) {
            handleArguments(args)
        }


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
         vRoot = inflater!!.inflate(mContentLayoutResourceId, container, false)
        setUpUi(vRoot)
        return vRoot
    }


    override fun onResume() {
        super<Fragment>.onResume()
    }

    override fun onPause() {
        super<Fragment>.onPause()

    }

    override fun onDestroy() {
        super<Fragment>.onDestroy()

    }


    open fun handleSavedInstanceState(savedInstanceState: Bundle) {

    }

    open fun handleArguments(args: Bundle) {

    }

    open fun setUpUi(view: View) {

    }

    open fun getRootView(): View {

        return vRoot;
    }


}