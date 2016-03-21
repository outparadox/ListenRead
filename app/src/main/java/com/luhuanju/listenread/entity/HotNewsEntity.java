package com.luhuanju.listenread.entity;/*
 * —————————————————————–
 * Copyright (C) 2016，上海宅米贸易有限公司， All rights reserved.
 * —————————————————————–
 * Author: luhuanju
 * 新闻实体类
 */

public class HotNewsEntity {
    private String title;
    private String imgsrc;
    private String content;
    private String url;
    private String time;
    private String remark;

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getUrl() {
        return url;
    }

    public String getTime() {
        return time;
    }
}
