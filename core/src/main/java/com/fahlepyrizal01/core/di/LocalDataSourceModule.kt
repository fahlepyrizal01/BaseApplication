package com.fahlepyrizal01.core.di

import com.fahlepyrizal01.core.data.source.local.ILocalDataSource
import com.fahlepyrizal01.core.data.source.local.LocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(local: LocalDataSource): ILocalDataSource

}