package com.fahlepyrizal01.api_game.domain.model

data class GameModel(

    val id: Int,
    val name: String,
    val slug: String,
    val backgroundImage: String,
    val website: String?,
    val descriptionRaw: String?,
    val released: String,
    val rating: Double,
    val ratingTop: Int,
    val ratingsCount: Int,
    val metacritic: Int

)