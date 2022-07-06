package com.fahlepyrizal01.api_game.data.source.local

import com.fahlepyrizal01.api_game.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface IGameLocalDataSource {

    //region GET
    fun getAllGame(): Flow<List<GameEntity>>
    //endregion

    //region SET
    suspend fun setAllGame(game: List<GameEntity>)
    //endregion

}