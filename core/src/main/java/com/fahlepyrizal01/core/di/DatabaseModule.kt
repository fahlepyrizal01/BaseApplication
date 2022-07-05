package com.fahlepyrizal01.core.di

import android.content.Context
import androidx.room.Room
import com.fahlepyrizal01.core.data.source.local.entity.SampleDatabase
import com.fahlepyrizal01.core.data.source.local.room.SampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SampleDatabase =
        Room.databaseBuilder(
            context,
            SampleDatabase::class.java, "Sample.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideSampleDao(database: SampleDatabase): SampleDao = database.tourismDao()

}