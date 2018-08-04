package cn.catherine.happyapplication.utills

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 *
 * HappyApplication
 *
 * cn.catherine.happyapplication.utills
 *
 * created by catherine in 八月/04/2018/下午2:44
 * 获取静态资源的工具类
 */
class GetResU {


}
fun Context.getAssetDrawable(): MutableList<Bitmap> {
    val allBgImage:MutableList<Bitmap> = arrayListOf()
    val allImagesPath: Array<String> = this.assets.list("drawable")
    println("通过文件读取出来的数据是：$allImagesPath")
    for (i in allImagesPath.indices) {
        val input = this.assets.open("drawable/${allImagesPath[i]}")
        val bitmap = BitmapFactory.decodeStream(input)
        allBgImage.add(bitmap)

    }
    return allBgImage

}