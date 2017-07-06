package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import java.io.InputStream

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/4 0004
 *Time: 11:29
 */
object AnimFactory {
    fun startAssetAnim(lottieAnimView: LottieAnimationView,fileName:String,
                           init: (LottieAnimationView.() -> Unit)?){
        AssetAnimImpl().createFromAssetFile(lottieAnimView,fileName,init)
    }
    fun startAssetAnim(context: Context,lottieAnimView: LottieAnimationView,fileName: String,
                           init: (LottieAnimationView.() -> Unit)?){
        AssetAnimImpl().createFromAssetFile(context,lottieAnimView,fileName,init)
    }

    fun startFileAnim(ctx:Context,lottieAnimView: LottieAnimationView,inputStream:InputStream){
        FileAnimImpl().createFromFileAnim(ctx,lottieAnimView,inputStream)
    }
    fun startJsonAnim(ctx:Context,lottieAnimView: LottieAnimationView,jsonStr:String){
        JsonAnimImpl().createJsonAnim(ctx,lottieAnimView,jsonStr)
    }

}