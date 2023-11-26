package com.example.kmasplash

import android.app.Application
import androidx.core.view.WindowCompat
import coil.Coil
import coil.ImageLoader
import com.example.kmasplash.core.Constants.REQUEST_TIMEOUT_IN_SECONDS
import dagger.hilt.android.HiltAndroidApp
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class KmaSplashApplication : Application(){


    override fun onCreate() {
        super.onCreate()
        setupCoil()

    }
    private fun setupCoil() {
        val imageLoader = ImageLoader.Builder(applicationContext)
            .okHttpClient {
                val dispatcher = Dispatcher().apply {
                    maxRequestsPerHost = 4
                }
                OkHttpClient.Builder()
                    .readTimeout(REQUEST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                    .connectTimeout(REQUEST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                    .dispatcher(dispatcher)
                    .build()
            }
            .crossfade(true)
            .build()
        Coil.setImageLoader(imageLoader)
    }
}
