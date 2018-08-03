package cn.catherine.happyapplication.base

import android.app.Application
import android.content.Context

/**
 *
 * HappyApplication
 *
 * cn.catherine.happyapplication.base
 *
 * created by catherine in 八月/03/2018/下午5:10
 */
class BaseApplication : Application() {
    init {

    }

    companion object {
        lateinit var instance: BaseApplication
        val context: Context by lazy { instance.applicationContext }

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}