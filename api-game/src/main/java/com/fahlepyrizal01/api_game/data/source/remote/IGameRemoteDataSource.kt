package com.fahlepyrizal01.api_game.data.source.remote

import com.fahlepyrizal01.api_game.data.source.remote.response.GameResponse
import com.fahlepyrizal01.core.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface IGameRemoteDataSource {

    //region GET
    fun getAllGame(): Flow<ApiResponse<List<GameResponse>>>
    //endregion

}