package com.fahlepyrizal01.api_game.di

import com.fahlepyrizal01.api_game.domain.usecase.GameInteractor
import com.fahlepyrizal01.api_game.domain.usecase.IGameUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun provideUseCase(interactor: GameInteractor): IGameUseCase

}