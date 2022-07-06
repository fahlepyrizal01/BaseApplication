package com.fahlepyrizal01.api_game.di

import com.fahlepyrizal01.api_game.data.GameRepository
import com.fahlepyrizal01.api_game.domain.repository.IGameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GameRepositoryModule {

    @Binds
    abstract fun provideRepository(repository: GameRepository): IGameRepository

}