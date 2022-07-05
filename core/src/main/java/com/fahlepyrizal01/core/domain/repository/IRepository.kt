package com.fahlepyrizal01.core.domain.repository

import com.fahlepyrizal01.core.utils.Resource
import com.fahlepyrizal01.core.domain.model.DataSampleModel
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAllRemoteData(): Flow<Resource<List<DataSampleModel>>>

    fun getAllLocalData(): Flow<Resource<List<DataSampleModel>>>

}