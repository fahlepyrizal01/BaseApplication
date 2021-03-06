package com.fahlepyrizal01.core.di

import com.fahlepyrizal01.core.data.source.remote.IRemoteDataSource
import com.fahlepyrizal01.core.data.source.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun provideRemoteDataSource(remote: RemoteDataSource): IRemoteDataSource

}