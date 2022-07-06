package com.fahlepyrizal01.api_game.domain.repository

import com.fahlepyrizal01.api_game.domain.model.GameModel
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IGameRepository {

    //region GET
    fun getAllGame(isFromLocal: Boolean): Flow<Resource<List<GameModel>>>
    //endregion

    //region SET
    suspend fun setAllGame(game: List<GameModel>): Flow<Resource<Boolean>>
    //endregion

}