package com.luhuanju.listenread.entity;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 */

public class HotNewsCarousEntity {

    private String url;
    private String thumbnailSrc;
    private String hdPictureSrc;
    private String content;
    private String title;


    public void setHdPictureSrc(String hdPictureSrc) {
        this.hdPictureSrc = hdPictureSrc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setThumbnailSrc(String thumbnailSrc) {
        this.thumbnailSrc = thumbnailSrc;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailSrc() {
        return thumbnailSrc;
    }

    public String getHdPictureSrc() {
        return hdPictureSrc;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
