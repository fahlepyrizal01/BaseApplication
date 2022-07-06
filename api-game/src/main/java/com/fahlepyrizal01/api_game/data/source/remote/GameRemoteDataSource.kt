package com.fahlepyrizal01.api_game.data.source.remote

import com.fahlepyrizal01.api_game.data.source.remote.network.GameService
import com.fahlepyrizal01.api_game.data.source.remote.response.GameResponse
import com.fahlepyrizal01.core.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRemoteDataSource @Inject constructor(
    private val api: GameService
) : IGameRemoteDataSource {

    //region GET
    override fun getAllGame(): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                val response = api.getAllData(1, 20)
                if (response.results.isNotEmpty()) emit(ApiResponse.Success(response.results))
                else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
    //endregion

}