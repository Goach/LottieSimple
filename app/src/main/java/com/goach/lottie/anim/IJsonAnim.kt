package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/6 0006
 *Time: 10:03
 */
interface IJsonAnim{
    fun createJsonAnim(ctx: Context,lottieAnimView: LottieAnimationView, jsonString: String)
}