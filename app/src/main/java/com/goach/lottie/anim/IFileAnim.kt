package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import java.io.InputStream

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/5 0005
 *Time: 16:11
 */
interface IFileAnim{
    fun createFromFileAnim(ctx:Context,lottieAnimView: LottieAnimationView,inputStream:InputStream)
}