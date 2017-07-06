package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import java.util.HashMap

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/4 0004
 *Time: 11:22
 */
class AssetAnimImpl : IAssetAnim {
    private val assetFolders = object : HashMap<String, String>() {
        init {
            put("WeAccept.json", "Images/WeAccept")
        }
    }
    override fun createFromAssetFile(lottieAnimView: LottieAnimationView, fileName: String, init: (LottieAnimationView.() -> Unit)?) {
        lottieAnimView.setAnimation(fileName)
        if(init!=null)
        lottieAnimView.init()
        lottieAnimView.playAnimation()
    }

    override fun createFromAssetFile(context: Context,lottieAnimView: LottieAnimationView,
                                     fileName: String, init: (LottieAnimationView.() -> Unit)?) {
        lottieAnimView.imageAssetsFolder = assetFolders[fileName]
        LottieComposition.Factory.fromAssetFileName(context,fileName) { composition ->
            lottieAnimView.setComposition(composition!!)
            if(init!=null)
                lottieAnimView.init()
            lottieAnimView.playAnimation()
        }
    }
}