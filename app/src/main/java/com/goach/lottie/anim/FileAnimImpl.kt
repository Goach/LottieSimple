package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import java.io.InputStream

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/5 0005
 *Time: 16:12
 */
class FileAnimImpl:IFileAnim{
    override fun createFromFileAnim(ctx: Context, lottieAnimView: LottieAnimationView, inputStream: InputStream) {
        LottieComposition.Factory.fromInputStream(ctx,inputStream) { composition ->
            if (composition == null) {
                return@fromInputStream
            }
            lottieAnimView.setComposition(composition)
            lottieAnimView.playAnimation()
        }
    }
}