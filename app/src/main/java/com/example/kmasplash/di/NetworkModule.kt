package com.example.kmasplash.di

import com.example.kmasplash.core.Constants.BASE_URL
import com.example.kmasplash.core.Constants.REQUEST_TIMEOUT_IN_SECONDS
import com.example.kmasplash.data.api.KmaSplashApi
import com.example.kmasplash.data.repository.PostRepositoryImpl
import com.example.kmasplash.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(REQUEST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(REQUEST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideKmaSplashApi(retrofit: Retrofit): KmaSplashApi {
        return retrofit.create(KmaSplashApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun providePostRepository(api: KmaSplashApi) : PostRepository {
        return PostRepositoryImpl(api)
    }
}
