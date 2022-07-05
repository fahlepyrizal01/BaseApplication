package com.fahlepyrizal01.baseapplication.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahlepyrizal01.core.domain.model.DataSampleModel
import com.fahlepyrizal01.core.domain.usecase.UseCase
import com.fahlepyrizal01.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    private var _data = MutableLiveData<Resource<List<DataSampleModel>>>()
    val data: LiveData<Resource<List<DataSampleModel>>> = _data

    suspend fun getData(isFromLocal: Boolean) {
        if (isFromLocal) useCase.getAllLocalData().collect { _data.postValue(it) }
        else useCase.getAllRemoteData().collect { _data.postValue(it) }
    }

}