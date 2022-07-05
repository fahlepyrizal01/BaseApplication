package com.fahlepyrizal01.core.domain.usecase

import com.fahlepyrizal01.core.domain.model.DataSampleModel
import com.fahlepyrizal01.core.domain.repository.IRepository
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repository: IRepository) : UseCase {

    override fun getAllRemoteData(): Flow<Resource<List<DataSampleModel>>> {
        return repository.getAllRemoteData()
    }

    override fun getAllLocalData(): Flow<Resource<List<DataSampleModel>>> {
        return repository.getAllLocalData()
    }

}