package com.luhuanju.listenread.models.impls;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import com.luhuanju.listenread.entity.HotNewsEntity;
import com.luhuanju.listenread.models.IHotNewsFragmentModel;
import com.luhuanju.listenread.uis.fragments.HotNewsFragment;
import com.luhuanju.listenread.utils.XMLDataParseUtil;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HotNewsFragmentModel implements IHotNewsFragmentModel, XMLDataParseUtil.DocumentPOJOCallback {
    private static final String HOTNEWS_BASE_URL = "http://news.163.com/shehui/";
    private List<HotNewsEntity> hotNewsEntities = new ArrayList<>();
    private HotNewsEntityPOJOCallBack mHotNewsEntityPOJOCallBack;
    private ListView mListView;
    private FragmentActivity mHomeActivity;


    public HotNewsFragmentModel(FragmentActivity activity, ListView listView) {
        this.mListView = listView;
        this.mHomeActivity = activity;

    }

    public HotNewsFragmentModel() {
    }


    @Override
    public <T> void onShowCarouseOnM(Activity activity) {

    }

    @Override
    public <T> List<HotNewsEntity> onShowDataOnM(FragmentActivity activity,ListView listView) {
        //监听回调，此处是监听document 对象并获得实体信息
        XMLDataParseUtil.onInstance().setDocumentPOJOListener(this);
        XMLDataParseUtil.onInstance().onDocumentPOJO(HOTNEWS_BASE_URL,activity,listView);
        return null;
    }


    @Override
    public List<HotNewsEntity> onDocumentPOJO(Document document,FragmentActivity activity,ListView listView) {
        Elements elements = document.getElementsByClass("item-top");
        for (Element element : elements) {
            onSetHotNewsEntity(element);
        }
        mHotNewsEntityPOJOCallBack = new HotNewsFragment();

        if (mHotNewsEntityPOJOCallBack != null) {
            if (hotNewsEntities != null && hotNewsEntities.size() > 0) {
                mHotNewsEntityPOJOCallBack.onHotNewsEntityPOJOSuccess(hotNewsEntities,activity, listView);
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


    public interface HotNewsEntityPOJOCallBack {

        abstract void onHotNewsEntityPOJOSuccess(List<HotNewsEntity> hotNewsEntities, FragmentActivity homeActivity,ListView listView);

        abstract void onHotNewsEntityPOJOFailed();
    }

    public void setHotNewsEntityPOJOListener(HotNewsEntityPOJOCallBack hotNewsEntityPOJOCallBack) {
        mHotNewsEntityPOJOCallBack = hotNewsEntityPOJOCallBack;
    }
}
