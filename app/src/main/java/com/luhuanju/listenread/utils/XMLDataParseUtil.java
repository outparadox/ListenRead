package com.luhuanju.listenread.utils;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class XMLDataParseUtil {
    private  DocumentPOJOCallback mDocumentPOJOCallback = null;
    private  Document mDocument;
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

    public interface DocumentPOJOCallback {
        void onDocumentPOJO(Document document);

    }

    public void setDocumentPOJOListener(DocumentPOJOCallback documentPOJOListener) {
        this.mDocumentPOJOCallback = documentPOJOListener;
    }


    public void onDocumentPOJO(String url) {

        new DocumentPOJOAsyncTask(url).execute();
    }

     class DocumentPOJOAsyncTask extends AsyncTask<Void, Void, Document> {
        private String mUrl;

        public DocumentPOJOAsyncTask(String url) {
            this.mUrl = url;

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
            if (document == null || mDocumentPOJOCallback == null) return;
            mDocumentPOJOCallback.onDocumentPOJO(document);
        }
    }


}
