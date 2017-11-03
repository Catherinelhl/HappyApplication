package cn.catherine.happyapplication.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by catherine on 2017/11/3.
 */
abstract class BaseAty : AppCompatActivity() {
    lateinit var context: Context
    lateinit var activity: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        activity = this
        intent.extras?.let { getArgs(it) }
        setContentView(layoutRes())
        initView()
        setListener()
    }

    abstract fun layoutRes(): Int
    abstract fun getArgs(bundle: Bundle)
    abstract fun initView()
    abstract fun setListener()
}