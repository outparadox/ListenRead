package com.luhuanju.listenread.utils;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class XMLDataParseUtil {
//    private DocumentPOJOCallback mDocumentPOJOCallback = null;
    private Document mDocument;
    private static XMLDataParseUtil mXmlDataParseUtil = null;

    private XMLDataParseUtil() {
    }


    /**
     * singleton
     *
     * @return
     */
    public static XMLDataParseUtil onInstance() {
        if (mXmlDataParseUtil == null) {
            synchronized (XMLDataParseUtil.class) {
                if (mXmlDataParseUtil == null) {
                    mXmlDataParseUtil = new XMLDataParseUtil();
                }
            }
        }
        return mXmlDataParseUtil;
    }


    /**
     * Callable和Future，一个产生结果，一个拿到结果
     *
     * @param baseUrl
     * @return document
     */
    public Document DocumentPOJO(final String baseUrl) {
        //单一线程的线程池
        ExecutorService threadPol = Executors.newSingleThreadExecutor();
        Future<Document> future = threadPol.submit(new Callable<Document>() {
            @Override
            public Document call() throws Exception {
                mDocument = Jsoup.connect(baseUrl).get();
                return mDocument;
            }
        });
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDocument;
    }




    /**
     * 设计欠缺 弃用
     */
    public void onDocumentPOJO(String url, FragmentActivity activity, ListView listView) {
        new DocumentPOJOAsyncTask(url, activity, listView).execute();
    }

    /**
     * 设计欠缺 弃用
     */
    class DocumentPOJOAsyncTask extends AsyncTask<Void, Void, Document> {
        private String mUrl;
        private FragmentActivity activity;
        private ListView listView;

        public DocumentPOJOAsyncTask(String url, FragmentActivity activity, ListView listView) {
            this.activity = activity;
            this.mUrl = url;
            this.listView = listView;

        }

        @Override
        protected Document doInBackground(Void... voids) {
            try {
                mDocument = Jsoup.connect(mUrl).get();
                return mDocument;
            } catch (IOException e) {
            }
            return mDocument;
        }

        @Override
        protected void onPostExecute(Document document) {
//            if (document == null || mDocumentPOJOCallback == null) return;
        }
    }


}
