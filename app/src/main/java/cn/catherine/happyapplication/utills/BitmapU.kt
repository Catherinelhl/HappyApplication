package cn.catherine.happyapplication.utills

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import cn.catherine.happyapplication.base.BaseApplication
import kotlin.coroutines.experimental.coroutineContext

/**
 *
 * HappyApplication
 *
 * cn.catherine.happyapplication.utills
 *
 * created by catherine in 八月/03/2018/下午4:36
 */
class BitmapU {


}

fun <T> T.blur(isScale: Boolean): Bitmap {

    var bitmap: Bitmap = when (this) {
        is Bitmap -> this
        else -> BitmapFactory.decodeResource(BaseApplication.context.resources, this as Int)
    }

    var width = bitmap.width
    var height = bitmap.height
    if (isScale) {
        width /= 8
        height /= 8
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true)
    }
    var renderScript = RenderScript.create(BaseApplication.context)

    val scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

    val input = Allocation.createFromBitmap(renderScript, bitmap)
    val output = Allocation.createTyped(renderScript, input.type)

    scriptIntrinsicBlur.setInput(input)

    scriptIntrinsicBlur.setRadius(if (isScale) 5.0f else 25.0f)
    scriptIntrinsicBlur.forEach(output)
    output.copyTo(bitmap)
    renderScript.destroy()
    return bitmap
}