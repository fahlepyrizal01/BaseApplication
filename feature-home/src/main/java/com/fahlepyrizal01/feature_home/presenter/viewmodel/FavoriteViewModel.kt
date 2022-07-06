package com.fahlepyrizal01.feature_home.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.api_game.domain.model.GameModel
import com.fahlepyrizal01.api_game.domain.usecase.IGameUseCase
import com.fahlepyrizal01.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val useCase: IGameUseCase) : ViewModel() {

    private var _games = MutableLiveData<Resource<List<GameModel>>>()
    val games: LiveData<Resource<List<GameModel>>> = _games

    suspend fun getData() {
        useCase.getAllGame(true).collect { _games.postValue(it) }
    }

}