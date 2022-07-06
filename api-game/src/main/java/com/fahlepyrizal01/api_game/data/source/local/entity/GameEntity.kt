package com.fahlepyrizal01.api_game.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "slug")
    val slug: String,

    @ColumnInfo(name = "background_image")
    val backgroundImage: String,

    @ColumnInfo(name = "website")
    val website: String?,

    @ColumnInfo(name = "description_raw")
    val descriptionRaw: String?,

    @ColumnInfo(name = "released")
    val released: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "rating_top")
    val ratingTop: Int,

    @ColumnInfo(name = "ratings_count")
    val ratingsCount: Int,

    @ColumnInfo(name = "metacritic")
    val metacritic: Int

)