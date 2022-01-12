package com.catfactscomposemvvm

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    
    var darkMode = mutableStateOf(false)
}