package com.fahlepyrizal01.api_game.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CommonResponse(

    @field:SerializedName("id")
    val next: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("image")
    val image: String

)