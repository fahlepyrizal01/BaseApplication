package com.fahlepyrizal01.core.data

import com.fahlepyrizal01.core.data.source.local.ILocalDataSource
import com.fahlepyrizal01.core.data.source.remote.IRemoteDataSource
import com.fahlepyrizal01.core.data.source.remote.network.ApiResponse
import com.fahlepyrizal01.core.domain.model.DataSampleModel
import com.fahlepyrizal01.core.domain.repository.IRepository
import com.fahlepyrizal01.core.utils.DataMapper.mapEntityToModel
import com.fahlepyrizal01.core.utils.DataMapper.mapResponseToModel
import com.fahlepyrizal01.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val remote: IRemoteDataSource, private val local: ILocalDataSource
) : IRepository {

    override fun getAllRemoteData(): Flow<Resource<List<DataSampleModel>>> {
        return flow {
            when (val apiResponse = remote.getAllData().first()) {
                is ApiResponse.Success -> emit(
                    Resource.Success(mapResponseToModel(apiResponse.data))
                )
                is ApiResponse.Empty -> Resource.Success(emptyList<DataSampleModel>())
                is ApiResponse.Error -> emit(Resource.Error(apiResponse.errorMessage))
            }
        }
    }

    override fun getAllLocalData(): Flow<Resource<List<DataSampleModel>>> {
        return flow {
            try {
                val data = local.getAllData().first()
                if (data.isEmpty()) emit(Resource.Success(emptyList()))
                else emit(Resource.Success(mapEntityToModel(data)))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(e.message.orEmpty()))
            }
        }
    }

}