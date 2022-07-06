package com.fahlepyrizal01.api_game.di

import com.fahlepyrizal01.api_game.data.source.remote.network.GameService
import com.fahlepyrizal01.core.utils.CoreConstants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class GameNetworkModule {

    @Provides
    fun provideApiService(client: OkHttpClient): GameService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(GameService::class.java)
    }

}