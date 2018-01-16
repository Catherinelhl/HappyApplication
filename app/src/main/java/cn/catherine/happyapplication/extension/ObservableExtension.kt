package cn.catherine.happyapplication.extension

import rx.Observable.Transformer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by catherine on 2018/1/16.
 * private
 * public
 * internal
 *
 */
class ObservableExtension{}

/**
 * 用于延时操作
 * */
fun <T> timer(): Transformer<T, T> = Transformer { t ->
    t.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}

/**
 * 用于处理流
 * */
fun <T> applyIoSchedulers(): Transformer<T, T> = Transformer { t ->
    t.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

