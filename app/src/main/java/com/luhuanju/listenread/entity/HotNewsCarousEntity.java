package com.luhuanju.listenread.entity;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

public class HotNewsCarousEntity {

    private String url;
    private String imgsrc;
    private String title;

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getImgsrc() {
        return imgsrc;
    }
}
