package com.luhuanju.listenread

/**
 * Created by huanjulu on 16/8/5.
 */

/**
 * 包含 类头 类名 类体
 * KotlinUtil  类名
 * constructor  代表是主构造函数 （）参数可选
 *
 *
 */
class KotlinUtil constructor(name: String) {

    var s: String = "adc";
    var b: String? = null;


    var userName = name.toString();

    /**
     * 类的初始化代码  类比JAVA 的STATIC ?
     */
    init {
        println("i am  init")
        println("length:" + b?.length);
    }


    fun sunUtil(a: Boolean, b: Boolean): Boolean {
        return a;
    }

    fun foo() {
        print("Foo")
    }

    /**
     * 二级构造函数
     */
    class KotlinUtil(str: String) {

    }


}

