package com.fahlepyrizal01.api_game.data.source.local

import com.fahlepyrizal01.api_game.data.source.local.entity.GameEntity
import com.fahlepyrizal01.api_game.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameLocalDataSource@Inject constructor(private val dao: GameDao): IGameLocalDataSource {

    //region GET
    override fun getAllGame(): Flow<List<GameEntity>> {
        return dao.getAllData()
    }
    //endregion

    //region GET
    override suspend fun setAllGame(game: List<GameEntity>) {
        dao.insertAllData(game)
    }
    //endregion

}