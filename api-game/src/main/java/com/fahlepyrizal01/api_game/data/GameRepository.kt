package com.fahlepyrizal01.api_game.data

import com.fahlepyrizal01.api_game.data.source.local.IGameLocalDataSource
import com.fahlepyrizal01.api_game.data.source.remote.IGameRemoteDataSource
import com.fahlepyrizal01.api_game.domain.model.GameModel
import com.fahlepyrizal01.api_game.domain.repository.IGameRepository
import com.fahlepyrizal01.api_game.utils.GameDataMapper.mapGameEntityToGameModel
import com.fahlepyrizal01.api_game.utils.GameDataMapper.mapGameModelToGameEntity
import com.fahlepyrizal01.api_game.utils.GameDataMapper.mapGameResponseToGameModel
import com.fahlepyrizal01.core.utils.ApiResponse
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val remote: IGameRemoteDataSource, private val local: IGameLocalDataSource
) : IGameRepository {

    //region GET
    override fun getAllGame(isFromLocal: Boolean): Flow<Resource<List<GameModel>>> {
        return flow {
            if (isFromLocal) {
                try {
                    val game = local.getAllGame().first()
                    if (game.isEmpty()) Resource.Success(emptyList<GameModel>())
                    else emit(
                        Resource.Success(mapGameEntityToGameModel(game))
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(e.message.orEmpty()))
                }
            } else {
                when (val apiResponse = remote.getAllGame().first()) {
                    is ApiResponse.Success -> emit(
                        Resource.Success(mapGameResponseToGameModel(apiResponse.data))
                    )
                    is ApiResponse.Empty -> Resource.Success(emptyList<GameModel>())
                    is ApiResponse.Error -> emit(Resource.Error(apiResponse.errorMessage))
                }
            }
        }
    }

    //region SET
    override suspend fun setAllGame(game: List<GameModel>): Flow<Resource<Boolean>> {
        return flow {
            try {
                local.setAllGame(mapGameModelToGameEntity(game))
                emit( Resource.Success(true))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(e.message.orEmpty()))
            }
        }
    }
    //endregion

}