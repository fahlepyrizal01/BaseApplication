package com.fahlepyrizal01.api_game.utils

import com.fahlepyrizal01.api_game.data.source.local.entity.GameEntity
import com.fahlepyrizal01.api_game.data.source.remote.response.GameResponse
import com.fahlepyrizal01.api_game.domain.model.GameModel

object GameDataMapper {

    internal fun mapGameResponseToGameModel(response: List<GameResponse>): List<GameModel> {
        return response.map {
            GameModel(
                it.id,
                it.name,
                it.slug,
                it.backgroundImage,
                it.website,
                it.descriptionRaw,
                it.released,
                it.rating,
                it.ratingTop,
                it.ratingsCount,
                it.metacritic
            )
        }
    }

    internal fun mapGameEntityToGameModel(response: List<GameEntity>): List<GameModel> {
        return response.map {
            GameModel(
                it.id,
                it.name,
                it.slug,
                it.backgroundImage,
                it.website,
                it.descriptionRaw,
                it.released,
                it.rating,
                it.ratingTop,
                it.ratingsCount,
                it.metacritic
            )
        }
    }

    internal fun mapGameModelToGameEntity(response: List<GameModel>): List<GameEntity> {
        return response.map {
            GameEntity(
                it.id,
                it.name,
                it.slug,
                it.backgroundImage,
                it.website,
                it.descriptionRaw,
                it.released,
                it.rating,
                it.ratingTop,
                it.ratingsCount,
                it.metacritic
            )
        }
    }

}