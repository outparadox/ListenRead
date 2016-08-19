package com.luhuanju.listenread.utils

import android.app.Activity
import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Created by huanjulu on 16/8/8.
 *
 *
 */

class KCommonUtil {


    companion object {

        /**
         * taost
         */
        @JvmStatic
        fun Activity.toast(activity: Activity, message: CharSequence, duratin: Int?) {
            Toast.makeText(activity, message, duratin ?: Toast.LENGTH_SHORT).show();
        }

        /**
         * creat gson
         */
        fun creatGson(): Gson {
            return GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        }

        fun isNotEmpty(content: String?): Boolean {
            if (content != null && !content.equals("") && content != "") return true else false;
            return true;
        }

        fun <T> analyticalGson(gsonString: String, classType: Class<T>): Class<T> {
            return Gson().fromJson(gsonString, classType.javaClass)
        }
    }
}






