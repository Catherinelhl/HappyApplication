package cn.catherine.happyapplication.aty

import android.os.Bundle
import cn.catherine.happyapplication.R
import cn.catherine.happyapplication.base.BaseAty
import cn.catherine.happyapplication.extension.intent
import kotlinx.android.synthetic.main.aty_guide.*

/**
 * Created by catherine on 2017/11/3.
 */
class GuideAty : BaseAty() {
    override fun layoutRes(): Int = R.layout.aty_guide

    override fun getArgs(bundle: Bundle) {
    }

    override fun initView() {
    }

    override fun setListener() {
        tv_guide.setOnClickListener {
            this.intent<MainAty>()
        }
    }

}