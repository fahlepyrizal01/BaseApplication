package com.fahlepyrizal01.core.data.source.local

import com.fahlepyrizal01.core.data.source.local.entity.DataSampleEntity
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {

    fun getAllData(): Flow<List<DataSampleEntity>>

}