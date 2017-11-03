package cn.catherine.happyapplication.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by catherine on 2017/11/3.
 *
 * 创建能跳转的Activity
 */
inline fun <reified T> Activity.intent() {
    this.intent<T>(null)
}

inline fun <reified T> Activity.intent(bundle: Bundle?) {
    this.intent<T>(bundle, false)
}

inline fun <reified T> Activity.intent(bundle: Bundle?, isFinish: Boolean) {
    val intent = Intent()
    bundle?.let {
        intent.putExtras(bundle)
    }
    intent.setClass(this, T::class.java)
    startActivity(intent)
    if (isFinish) finish()
}
