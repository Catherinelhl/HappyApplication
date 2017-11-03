package cn.catherine.happyapplication.utills

import android.util.Log


/**
 * Created by catherine on 2017/11/3.
 *
 * 得到当前的日志信息
 */
object L {
    private var TAG = "Happy"
    private var line = "--------"
    fun line() {
        line(line)
    }

    fun line(str: String) {
        var className = getMethodNames(Thread.currentThread().stackTrace)
        Log.i(TAG, " $className$line$str")

    }

    private fun getMethodNames(sElements: Array<StackTraceElement>): String {
        var className = ""
        val index = 3
        try {
            className = sElements[index].toString()
        } catch (e: Exception) {
            ExceptionU.print(e)
        }
        return className
    }

}