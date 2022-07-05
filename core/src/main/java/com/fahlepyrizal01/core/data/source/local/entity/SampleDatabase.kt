package com.fahlepyrizal01.core.data.source.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fahlepyrizal01.core.data.source.local.room.SampleDao
import com.fahlepyrizal01.core.utils.CoreConstants.DB_VERSION

@Database(entities = [DataSampleEntity::class], version = DB_VERSION, exportSchema = false)
abstract class SampleDatabase : RoomDatabase() {

    abstract fun tourismDao(): SampleDao

}