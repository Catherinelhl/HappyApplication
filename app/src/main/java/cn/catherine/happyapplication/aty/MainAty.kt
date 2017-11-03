package cn.catherine.happyapplication.aty

import android.os.Bundle
import cn.catherine.happyapplication.R
import cn.catherine.happyapplication.base.BaseAty

class MainAty : BaseAty() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aty_main)
    }
}
