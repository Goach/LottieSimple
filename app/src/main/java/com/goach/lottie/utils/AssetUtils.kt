package com.goach.lottie.utils

import android.content.Context

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/6/27 0027
 *Time: 10:04
 */
class AssetUtils{
    companion object {
        fun getJsonAssets(context: Context, path:String):List<String>{
            val assetList = context.assets.list(path)
            return assetList.filter { it.toLowerCase().endsWith(".json") }
        }
    }
}