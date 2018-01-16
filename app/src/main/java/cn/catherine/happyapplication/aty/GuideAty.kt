package cn.catherine.happyapplication.aty

import android.os.Bundle
import cn.catherine.happyapplication.R
import cn.catherine.happyapplication.base.BaseAty
import cn.catherine.happyapplication.extension.intent
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.aty_guide.*

/**
 * Created by catherine on 2017/11/3.
 */
class GuideAty : BaseAty() {
    override fun layoutRes(): Int = R.layout.aty_guide

    override fun getArgs(bundle: Bundle) {
    }

    override fun initView() {
        Glide.with(context)
                .load("http://b199.photo.store.qq.com/psbe?/V13feNMj3t71kv/HcLZlTKEONf04rJs29Y1RAPyCB1kR3nugi*pQF11S8ELBTLqU5eeopsHR5HffUSO/b/dMcAAAAAAAAA&bo=uALrAgAAAAAFB3c!&rf=viewer_4")
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(iv_bg)
    }

    override fun setListener() {
        btn_start_music.setOnClickListener { this.intent<MainAty>() }
    }
}