package com.luhuanju.listenread

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.luhuanju.listenread.utils.application.AppApplication
import org.jetbrains.anko.button
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout
import java.util.*

class kotlinActivity : AppCompatActivity() {


    //没有类型定义
    //val 不可修改
    //var 可修改
    val name = "JACK";
    val people = ArrayList<String>();
    val asas = Int;


    companion object Factory{
        private var appApplication: AppApplication? = null;
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        verticalLayout {

            button {
                width = 100;
                height = 100;
                text = "btn"
                textSize = 20f;


                onClick {
                    view ->
                    toast("hello kotlin!")
                }
            }

        }
    }


    /**
     * fun 代表函数  函数关键字
     * sum 函数名
     * 参数
     * 返回值
     *
     */
    fun sum(a: Int, b: Int): Int {
        return b + a;
    }

    /**
     * 等同于上述函数
     * b: Int = 1 默认参数值
     */
    fun sums(a: Int, b: Int = 1, wordChar: Char = ' ') = a + b;

    fun noVoid(name: String): Unit {
        if (name != null) {
            println(name)
        }
    }


}
