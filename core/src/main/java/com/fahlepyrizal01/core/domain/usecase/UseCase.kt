package com.fahlepyrizal01.core.domain.usecase

import com.fahlepyrizal01.core.domain.model.DataSampleModel
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UseCase {

    fun getAllRemoteData(): Flow<Resource<List<DataSampleModel>>>

    fun getAllLocalData(): Flow<Resource<List<DataSampleModel>>>

}