package com.fahlepyrizal01.api_game.di

import android.content.Context
import androidx.room.Room
import com.fahlepyrizal01.api_game.data.source.local.entity.GameDatabase
import com.fahlepyrizal01.api_game.data.source.local.room.GameDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GameDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): GameDatabase =
        Room.databaseBuilder(
            context,
            GameDatabase::class.java, "Game.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideGameDao(database: GameDatabase): GameDao = database.gameDao()

}