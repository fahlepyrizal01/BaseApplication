package com.fahlepyrizal01.api_game.domain.usecase

import com.fahlepyrizal01.api_game.domain.model.GameModel
import com.fahlepyrizal01.api_game.domain.repository.IGameRepository
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameInteractor @Inject constructor(private val repository: IGameRepository) : IGameUseCase {

    //region GET
    override fun getAllGame(isFromLocal: Boolean): Flow<Resource<List<GameModel>>> {
        return repository.getAllGame(isFromLocal)
    }

    override suspend fun setAllGame(game: List<GameModel>): Flow<Resource<Boolean>> {
        return repository.setAllGame(game)
    }
    //endregion

    //region SET
//    suspend fun setAllGame(game: List<GameModel>)
    //endregion

}