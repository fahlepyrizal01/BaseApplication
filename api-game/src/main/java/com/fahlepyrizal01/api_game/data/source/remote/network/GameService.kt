package com.fahlepyrizal01.api_game.data.source.remote.network

import com.fahlepyrizal01.api_game.data.source.remote.response.GamesResponse
import com.fahlepyrizal01.core.utils.CoreConstants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {

    //region GET
    @GET("games")
    suspend fun getAllData(
        @Query("page") page: Int,
        @Query("page_size") page_size: Int,
        @Query("key") key: String = API_KEY
    ): GamesResponse
    //endregion

}