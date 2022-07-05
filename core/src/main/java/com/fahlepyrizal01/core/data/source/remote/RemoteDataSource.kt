package com.fahlepyrizal01.core.data.source.remote

import android.util.Log
import com.fahlepyrizal01.core.data.source.remote.network.ApiResponse
import com.fahlepyrizal01.core.data.source.remote.network.ApiService
import com.fahlepyrizal01.core.data.source.remote.response.DataSampleResponse
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val api: ApiService): IRemoteDataSource {

    //region GET
    override fun getAllData(): Flow<ApiResponse<List<DataSampleResponse>>> {
        return flow {
            try {
                val response = api.getAllData()
                if (response.data.isNotEmpty()) emit(ApiResponse.Success(response.data))
                else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(IO)
    }
    //endregion

}