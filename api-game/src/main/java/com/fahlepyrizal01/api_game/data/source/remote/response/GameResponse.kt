package com.fahlepyrizal01.api_game.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("slug")
    val slug: String,

    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("website")
    val website: String?,

    @field:SerializedName("description_raw")
    val descriptionRaw: String?,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("rating_top")
    val ratingTop: Int,

    @field:SerializedName("ratings_count")
    val ratingsCount: Int,

    @field:SerializedName("metacritic")
    val metacritic: Int,

    @field:SerializedName("platforms")
    val platforms: List<PlatformResponse>,

    @field:SerializedName("genres")
    val genres: List<CommonResponse>,

    @field:SerializedName("short_screenshots")
    val shortScreenshots: List<CommonResponse>,

    @field:SerializedName("developers")
    val developers: List<CommonResponse>,

    @field:SerializedName("publishers")
    val publishers: List<CommonResponse>,

    @field:SerializedName("stores")
    val stores: List<StoreResponse>

)