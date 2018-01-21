package cn.catherine.happyapplication.aty

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import cn.catherine.happyapplication.R
import cn.catherine.happyapplication.base.BaseAty
import kotlinx.android.synthetic.main.aty_main.*
import java.util.*

class MainAty : BaseAty() {

    //需将资源文件放在assets文件夹
    private lateinit var fd: AssetFileDescriptor
    private val mediaPlayer = MediaPlayer()
    private val allBgImage = arrayOf(R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
            R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.even, R.drawable.twen,
            R.drawable.thr)

    override fun layoutRes(): Int = R.layout.aty_main

    override fun getArgs(bundle: Bundle) {
    }

    override fun initView() {

        //        Glide.with(context)
//                .load("http://b199.photo.store.qq.com/psbe?/V13feNMj3t71kv/HcLZlTKEONf04rJs29Y1RAPyCB1kR3nugi*pQF11S8ELBTLqU5eeopsHR5HffUSO/b/dMcAAAAAAAAA&bo=uALrAgAAAAAFB3c!&rf=viewer_4")
//                .placeholder(R.drawable.one)
//                .crossFade()
//                .into(iv_bg)
        initMediaPlayer()
        initAnimation()
    }

    override fun setListener() {
        iv_start_music.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                iv_start_music.setImageResource(R.drawable.ic_start_music_d)
                mediaPlayer.pause()
            } else {
                iv_start_music.setImageResource(R.drawable.ic_start_music)
                mediaPlayer.start()

            }

        }

        btn_go_on.setOnClickListener {
            var index = (Math.random() * allBgImage.size).toInt()
            iv_bg.setImageResource(allBgImage[index])
        }
    }

    private fun initMediaPlayer() {
        fd = assets.openFd(getString(R.string.music_name))
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
        mediaPlayer.isLooping = true
    }

    private fun initAnimation() {
        var animation = AnimationUtils.loadAnimation(this, R.anim.start_music)
        var lin = LinearInterpolator()
        animation.interpolator = lin
        iv_start_music.animation = animation
    }


    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }

}
