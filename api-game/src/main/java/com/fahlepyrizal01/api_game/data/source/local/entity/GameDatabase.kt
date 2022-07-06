package com.fahlepyrizal01.api_game.data.source.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fahlepyrizal01.api_game.data.source.local.room.GameDao
import com.fahlepyrizal01.core.utils.CoreConstants.DB_VERSION

@Database(entities = [GameEntity::class], version = DB_VERSION, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

}