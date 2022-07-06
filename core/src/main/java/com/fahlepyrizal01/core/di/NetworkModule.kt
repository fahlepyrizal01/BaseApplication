package com.fahlepyrizal01.core.di

import com.fahlepyrizal01.core.utils.CoreConstants.TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import java.util.concurrent.TimeUnit.SECONDS

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
            .connectTimeout(TIMEOUT, SECONDS)
            .readTimeout(TIMEOUT, SECONDS)
            .build()
    }

}