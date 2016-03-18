package com.luhuanju.listenread.models.impls;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.app.Activity;
import android.util.Log;

import com.luhuanju.listenread.entity.HotNewsEntity;
import com.luhuanju.listenread.models.IHotNewsFragmentModel;
import com.luhuanju.listenread.utils.XMLDataParseUtil;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HotNewsFragmentModel implements IHotNewsFragmentModel, XMLDataParseUtil.DocumentPOJOCallback {
    private static final String HOTNEWS_BASE_URL = "http://news.163.com/shehui/";


    @Override
    public <T> void onShowCarouseOnM(Activity activity) {

    }

    @Override
    public <T> void onShowDataOnM(Activity activity) {
        //监听回调
        XMLDataParseUtil.onInstance().setDocumentPOJOListener(this);
        XMLDataParseUtil.onInstance().onDocumentPOJO(HOTNEWS_BASE_URL);


    }


    @Override
    public void onDocumentPOJO(Document document) {
        if (document == null) return;
        Elements elements = document.getElementsByClass("item-top");
        for (Element element : elements) {
            Log.d("TAG", "：+" + element.getElementsByTag("a").attr("href"));
//            Log.d("TAG", "：+" + element.getElementsByTag("a").text());
//            Log.d("TAG", "：+" + element.getElementsByTag("a").text());
//            Log.d("TAG", "：+" + element.select("a").text());
//            Log.d("TAG", "：+" + element.select("span.time").text());
//            Log.d("TAG", "：+" + element.select("span.time").text());
//            Log.d("TAG", "：+" + element.select("p"));


        }


//        try {
//            Document document = Jsoup.connect(HttpUrlModel.HOTNEWS_HTTP_URL).get();
//
//            Elements elements = document.getElementsByClass("item-top");  //属性
//            for (int i = 0; i < elements.size(); i++) {
////                Log.d("TAG", "：+" + elements.get(i).getElementsByTag("a").attr("title"));
//                Log.d("TAG", "：+" + elements.get(i).getElementsByTag("a").text());
//            }
//        } catch (IOException e) {
//        }


    }

    private void onSetHotNewsEntity(Element element) {
        HotNewsEntity hotNewsEntity = new HotNewsEntity();
        hotNewsEntity.setTitle(element.getElementsByTag("a").text());
        hotNewsEntity.setTime(element.select("span.time").text());//TOP大DIV->ID为time的SPAN属性值
        hotNewsEntity.setUrl(element.getElementsByTag("a").attr("href"));//TOP大DIV->a标签->HREF的值

    }
}
