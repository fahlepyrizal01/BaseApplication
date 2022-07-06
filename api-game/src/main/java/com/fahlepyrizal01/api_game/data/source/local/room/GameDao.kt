package com.fahlepyrizal01.api_game.data.source.local.room

import androidx.room.*
import com.fahlepyrizal01.api_game.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    //region GET
    @Query("SELECT * FROM game")
    fun getAllData(): Flow<List<GameEntity>>
    //endregion

    //region INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(data: List<GameEntity>)
    //endregion

}