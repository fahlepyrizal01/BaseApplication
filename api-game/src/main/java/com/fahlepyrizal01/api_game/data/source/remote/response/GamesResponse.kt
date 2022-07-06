package com.fahlepyrizal01.api_game.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(

    @field:SerializedName("next")
    val next: String,

    @field:SerializedName("previous")
    val previous: String,

    @field:SerializedName("results")
    val results: List<GameResponse>

)