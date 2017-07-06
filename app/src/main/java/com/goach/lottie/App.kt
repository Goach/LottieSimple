package com.goach.lottie

import android.app.Application
import timber.log.Timber

/**
 * Goach All Rights Reserved
 *User: Goach
 *Date: 2017/6/29 0029
 *Time: 14:05
 */
class App: Application(){
    override fun onCreate() {
        super.onCreate()
        initLog()
    }
    fun initLog(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}