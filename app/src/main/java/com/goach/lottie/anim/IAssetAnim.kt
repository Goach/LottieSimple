package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/4 0004
 *Time: 11:19
 */
interface IAssetAnim {
    fun createFromAssetFile(lottieAnimView: LottieAnimationView,fileName:String,
                            init:(LottieAnimationView.()-> Unit)? = null)
    fun createFromAssetFile(context: Context,lottieAnimView: LottieAnimationView,fileName:String,
                            init:(LottieAnimationView.()-> Unit)? = null)
}