package com.fahlepyrizal01.core.data.source.remote

import com.fahlepyrizal01.core.data.source.remote.network.ApiResponse
import com.fahlepyrizal01.core.data.source.remote.response.DataSampleResponse
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {

    fun getAllData(): Flow<ApiResponse<List<DataSampleResponse>>>

}