package com.fahlepyrizal01.core.data.source.local

import androidx.room.Query
import com.fahlepyrizal01.core.data.source.local.entity.DataSampleEntity
import com.fahlepyrizal01.core.data.source.local.room.SampleDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource@Inject constructor(private val dao: SampleDao): ILocalDataSource {

    //region GET
    override fun getAllData(): Flow<List<DataSampleEntity>> = dao.getAllData()
    //endregion

}