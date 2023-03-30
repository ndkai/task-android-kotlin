package com.iot.taskmanagerandroid

import android.app.Application
import android.content.res.Configuration
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TaskApplication: Application(), androidx.work.Configuration.Provider {
 
    override fun getWorkManagerConfiguration(): androidx.work.Configuration {
        TODO("Not yet implemented")
    }

}