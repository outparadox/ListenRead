package com.luhuanju.listenread.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass

/**
 * Created by huanjulu on 16/8/11.
 */
@RealmClass
open class KHotNewsEntity : RealmObject() {


    @SerializedName("code")
    @Expose
    open var code: Int = 0;

    @SerializedName("msg")
    @Expose
    open var msg: String = "";

    @SerializedName("newslist")
    @Expose
    open var newslist = emptyList<HotNews>()


    inner class HotNews {

        @SerializedName("ctime")
        @Expose
        open var ctime: String = "";


        @SerializedName("title")
        @Expose
        open var title: String = "";


        @SerializedName("description")
        @Expose
        open var description: String = "";

        @SerializedName("picUrl")
        @Expose
        open var picUrl: String = "";

        @SerializedName("url")
        @Expose
        open var url: String = "";


    }
}
