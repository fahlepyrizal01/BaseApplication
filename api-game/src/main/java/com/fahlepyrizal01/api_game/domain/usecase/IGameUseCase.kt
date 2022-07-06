package com.fahlepyrizal01.api_game.domain.usecase

import com.fahlepyrizal01.api_game.domain.model.GameModel
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IGameUseCase {

    //region GET
    fun getAllGame(isFromLocal: Boolean): Flow<Resource<List<GameModel>>>
    //endregion

    //region SET
    suspend fun setAllGame(game: List<GameModel>): Flow<Resource<Boolean>>
    //endregion

}