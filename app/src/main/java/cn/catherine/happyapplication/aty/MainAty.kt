package cn.catherine.happyapplication.aty

import android.content.res.AssetFileDescriptor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import cn.catherine.happyapplication.R
import cn.catherine.happyapplication.base.BaseAty
import cn.catherine.happyapplication.utills.GetResU
import cn.catherine.happyapplication.utills.blur
import cn.catherine.happyapplication.utills.getAssetDrawable
import kotlinx.android.synthetic.main.aty_main.*

class MainAty : BaseAty() {

    //需将资源文件放在assets文件夹
    private lateinit var fd: AssetFileDescriptor
    private val mediaPlayer = MediaPlayer()
    private lateinit var allBgImage: MutableList<Bitmap>

    override fun layoutRes(): Int = R.layout.aty_main

    override fun getArgs(bundle: Bundle) {
    }

    override fun initView() {

        //        Glide.w]ith(context)
//                .load("http://b199.photo.store.qq.com/psbe?/V13feNMj3t71kv/HcLZlTKEONf04rJs29Y1RAPyCB1kR3nugi*pQF11S8ELBTLqU5eeopsHR5HffUSO/b/dMcAAAAAAAAA&bo=uALrAgAAAAAFB3c!&rf=viewer_4")
//                .placeholder(R.drawable.one)
//                .crossFade()
//                .into(iv_bg)

        allBgImage = this.getAssetDrawable()
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
            iv_bg.setImageBitmap(allBgImage[index].blur(false))
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
