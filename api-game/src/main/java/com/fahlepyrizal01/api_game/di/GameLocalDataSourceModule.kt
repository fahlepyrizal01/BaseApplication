package com.fahlepyrizal01.api_game.di

import com.fahlepyrizal01.api_game.data.source.local.GameLocalDataSource
import com.fahlepyrizal01.api_game.data.source.local.IGameLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GameLocalDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(local: GameLocalDataSource): IGameLocalDataSource

}