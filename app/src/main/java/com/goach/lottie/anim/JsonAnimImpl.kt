package com.goach.lottie.anim

import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.OnCompositionLoadedListener
import org.json.JSONException
import org.json.JSONObject

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/7/6 0006
 *Time: 10:05
 */
class JsonAnimImpl:IJsonAnim{
    override fun createJsonAnim(ctx: Context,lottieAnimView: LottieAnimationView, jsonString: String) {
        try {
            val json = JSONObject(jsonString)
            LottieComposition.Factory
                    .fromJson(ctx.resources, json, OnCompositionLoadedListener { composition ->
                        if (composition == null) {
                            return@OnCompositionLoadedListener
                        }
                        lottieAnimView.setComposition(composition)
                        lottieAnimView.playAnimation()
                    })
        } catch (e: JSONException) {

        }
    }
}