package com.luhuanju.listenread.uis.fragments

/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * 热点新闻Fragment
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.Indicators.PagerIndicator
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.luhuanju.listenread.R
import com.luhuanju.listenread.contracts.IHotNewsFragmenrContract
import com.luhuanju.listenread.entity.HotNewsWrap
import com.luhuanju.listenread.presenters.HotNewsFragmentPresenter
import com.luhuanju.listenread.uis.adapters.HotNewsDataAdapter
import com.tuesda.walker.circlerefresh.CircleRefreshLayout
import java.util.*

class KHotNewsFragment : Fragment(), IHotNewsFragmenrContract.IHotNewstVu, CircleRefreshLayout.OnCircleRefreshListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.hotnews_recy)
    internal var mShowDataRecy: RecyclerView? = null
    @BindView(R.id.hotnews_slider)
    internal var mCarouseSlider: SliderLayout? = null


    private val mData: Array<String>? = null
    private var mRefreshLayout: CircleRefreshLayout? = null
    private var mIHotNewsFragmentPresenter: IHotNewsFragmenrContract.IHomeNewsPresenter? = null
    private var mHotNewsDataAdapter: HotNewsDataAdapter? = null
    private val mHotNewsEntities = ArrayList<HotNewsWrap.DataEntity.ArticleEntity>()
    private val mLayoutManager = LinearLayoutManager(activity)
    private var mPage = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_hotnews, null)
        initViewWidget(view)
        initData(view)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


    override fun onShowCarouse(hotNewsCarousEntities: List<HotNewsWrap.DataEntity.ArticleEntity> ?) {
        if (hotNewsCarousEntities == null) return
        if (mCarouseSlider!!.tag == null) {
            for (hotNewsCarousEntity in hotNewsCarousEntities) {
                val textSliderView = TextSliderView(activity)
                textSliderView.description(hotNewsCarousEntity.title).image(hotNewsCarousEntity.img).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this)
                textSliderView.bundle(Bundle())
                textSliderView.bundle.putString("extra", hotNewsCarousEntity.title)

                mCarouseSlider!!.addSlider(textSliderView)
            }
            mCarouseSlider!!.indicatorVisibility = PagerIndicator.IndicatorVisibility.Invisible
            mCarouseSlider!!.setPresetTransformer(SliderLayout.Transformer.Accordion)
            mCarouseSlider!!.setCustomAnimation(DescriptionAnimation())
            mCarouseSlider!!.setDuration(4000)
            mCarouseSlider!!.addOnPageChangeListener(this)
            mCarouseSlider!!.tag = hotNewsCarousEntities!!.size
        }


    }

    override fun <T> onShowData(hotNewsEntities:  List<HotNewsWrap.DataEntity.ArticleEntity> ) {
        mHotNewsDataAdapter!!.refreshData(hotNewsEntities)
    }

    override fun onStop() {
        mCarouseSlider!!.stopAutoCycle()
        super.onStop()
    }

    override fun onDestroyView() {

        super.onDestroyView()
    }

    override fun completeRefresh() {

    }

    override fun refreshing() {
        mPage += 1
        mIHotNewsFragmentPresenter!!.onShowDataOnP<Any>(activity, mPage)
    }


    /**
     * 初始化界面相关控件

     * @param view
     */
    private fun initViewWidget(view: View) {

        mRefreshLayout = view.findViewById(R.id.hotnews_refresh) as CircleRefreshLayout


    }

    /**
     * 初始化界面相关数据

     * @param view
     */
    private fun initData(view: View) {
        ButterKnife.bind(this, view)
        HotNewsFragmentPresenter(this)
        mHotNewsDataAdapter = HotNewsDataAdapter(activity, mHotNewsEntities)
        mShowDataRecy!!.adapter = mHotNewsDataAdapter
        mShowDataRecy!!.layoutManager = mLayoutManager
        mIHotNewsFragmentPresenter!!.onShowCarouseOnP<Any>(activity)
        mIHotNewsFragmentPresenter!!.onShowDataOnP<Any>(activity, mPage)


    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onSliderClick(slider: BaseSliderView) {

    }

    override fun <T> onSetPresenter(t: T) {
        this.mIHotNewsFragmentPresenter = t as IHotNewsFragmenrContract.IHomeNewsPresenter
    }
}
