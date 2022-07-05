package com.fahlepyrizal01.core.di

import com.fahlepyrizal01.core.domain.usecase.Interactor
import com.fahlepyrizal01.core.domain.usecase.UseCase
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
    abstract fun provideUseCase(interactor: Interactor): UseCase

}