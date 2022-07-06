package com.fahlepyrizal01.api_game.di

import com.fahlepyrizal01.api_game.data.source.remote.GameRemoteDataSource
import com.fahlepyrizal01.api_game.data.source.remote.IGameRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GameRemoteDataSourceModule {

    @Binds
    abstract fun provideRemoteDataSource(remote: GameRemoteDataSource): IGameRemoteDataSource

}