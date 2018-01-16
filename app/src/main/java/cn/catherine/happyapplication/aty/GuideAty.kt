package cn.catherine.happyapplication.aty

import android.os.Bundle
import cn.catherine.happyapplication.R
import cn.catherine.happyapplication.base.BaseAty
import cn.catherine.happyapplication.extension.intent
import cn.catherine.happyapplication.extension.timer
import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by catherine on 2017/11/3.
 */
class GuideAty : BaseAty() {

    override fun layoutRes(): Int = R.layout.aty_guide

    override fun getArgs(bundle: Bundle) {
    }

    override fun initView() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(4)
                .compose(timer())
                .subscribe {
                    if (it == 3L) {
                        this.intent<MainAty>()
                    }
                }
    }

    override fun setListener() {

    }


}