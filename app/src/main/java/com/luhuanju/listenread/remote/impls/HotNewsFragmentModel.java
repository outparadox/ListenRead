package com.luhuanju.listenread.remote.impls;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 *
 *
 */

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ListView;

import com.luhuanju.listenread.entity.HotNewsCarousEntity;
import com.luhuanju.listenread.entity.HotNewsEntity;
import com.luhuanju.listenread.remote.IHotNewsFragmentModel;
import com.luhuanju.listenread.utils.XMLDataParseUtil;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HotNewsFragmentModel implements IHotNewsFragmentModel, XMLDataParseUtil.DocumentPOJOCallback {
    private static final String TAG = HotNewsFragmentModel.class.getName().toString();
    private static final String HOTNEWS_BASE_URL = "http://news.163.com/shehui/";
    private static final String HOTNEWS_CAROUSE_BASE_URL = "http://cnews.chinadaily.com.cn/";//中国日报网
    private List<HotNewsEntity> hotNewsEntities = new ArrayList<>();
    private List<HotNewsCarousEntity> mHotNewsCarousEntity = new ArrayList<>();
    private HotNewsEntityPOJOCallBack mHotNewsEntityPOJOCallBack;

    public HotNewsFragmentModel() {
    }


    @Override
    public <T> List<HotNewsCarousEntity> onShowCarouseOnM() {
//        for (Element element : XMLDataParseUtil.onInstance().DocumentPOJO(HOTNEWS_CAROUSE_BASE_URL).getElementsByTag("picarea").first().getElementsByTag("image")) {
//            onSetHotNewsCurouseEntity(element);
//        }
//        return mHotNewsCarousEntity;
        return null;
    }

    @Override
    public <T> List<HotNewsEntity> onShowDataOnM() {
        //监听回调，此处是监听document 对象并获得实体信息
//        XMLDataParseUtil.onInstance().setDocumentPOJOListener(this);
//        XMLDataParseUtil.onInstance().onDocumentPOJO(HOTNEWS_BASE_URL, activity, listView);
//        XMLDataParseUtil.onInstance().DocumentPOJO(HOTNEWS_BASE_URL);

//        for (Element element : XMLDataParseUtil.onInstance().DocumentPOJO(HOTNEWS_BASE_URL).getElementsByClass("item-top")) {
//            onSetHotNewsEntity(element);
//        }
        return null;
    }


    @Override
    public List<HotNewsEntity> onDocumentPOJO(Document document, FragmentActivity activity, ListView listView) {
        Elements elements = document.getElementsByClass("item-top");
        for (Element element : elements) {
            onSetHotNewsEntity(element);
        }
        if (mHotNewsEntityPOJOCallBack != null) {
            if (hotNewsEntities != null && hotNewsEntities.size() > 0) {
                mHotNewsEntityPOJOCallBack.onHotNewsEntityPOJOSuccess(hotNewsEntities, activity, listView);
            } else
                mHotNewsEntityPOJOCallBack.onHotNewsEntityPOJOFailed();
        }
        return hotNewsEntities;

    }

    /**
     * 设置OJPJ
     *
     * @param element
     */
    private void onSetHotNewsEntity(Element element) {
        HotNewsEntity hotNewsEntity = new HotNewsEntity();
        hotNewsEntity.setTitle(element.getElementsByTag("a").text());
        hotNewsEntity.setTime(element.select("span.time").text());//TOP大DIV->ID为time的SPAN属性值
        hotNewsEntity.setUrl(element.getElementsByTag("a").attr("href"));//TOP大DIV->a标签->HREF的值
        hotNewsEntity.setImgsrc(element.getElementsByTag("img").attr("src"));//图片地址，可能NULL
        hotNewsEntity.setRemark(element.getElementsByTag("p").first().text().substring(0, element.getElementsByTag("p").first().text().length() - 20));//简述内容待处理
        hotNewsEntities.add(hotNewsEntity);
    }

    /**
     * @param element
     */
    private void onSetHotNewsCurouseEntity(Element element) {
        HotNewsCarousEntity hotNewsCarousEntity = new HotNewsCarousEntity();
//        hotNewsCarousEntity.setTitle(element.getElementsByTag("p").text());
        Log.d("TAG","："+element.getElementsByClass("word_cont").text());
//        HotNewsCarousEntity hotNewsCarousEntity = new HotNewsCarousEntity();
//        hotNewsCarousEntity.setTitle(element.getElementsByTag("img").attr("alt"));
//        hotNewsCarousEntity.setThumbnailSrc("http://www.people.com.cn" + element.getElementsByTag("img").attr("src"));
//        hotNewsCarousEntity.setUrl(element.getElementsByTag("a").first().attr("href"));
        //依据地址获取具体内容以及大图
//        XMLDataParseUtil.onInstance().DocumentPOJO(hotNewsCarousEntity.getUrl())


        mHotNewsCarousEntity.add(hotNewsCarousEntity);
    }


    /**
     * 设计欠缺 弃用
     */
    public interface HotNewsEntityPOJOCallBack {

        abstract void onHotNewsEntityPOJOSuccess(List<HotNewsEntity> hotNewsEntities, FragmentActivity homeActivity, ListView listView);

        abstract void onHotNewsEntityPOJOFailed();
    }

    public void setHotNewsEntityPOJOListener(HotNewsEntityPOJOCallBack hotNewsEntityPOJOCallBack) {
        mHotNewsEntityPOJOCallBack = hotNewsEntityPOJOCallBack;
    }
}
