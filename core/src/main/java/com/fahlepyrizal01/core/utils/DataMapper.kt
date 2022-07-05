package com.fahlepyrizal01.core.utils

import com.fahlepyrizal01.core.data.source.local.entity.DataSampleEntity
import com.fahlepyrizal01.core.data.source.remote.response.DataSampleResponse
import com.fahlepyrizal01.core.domain.model.DataSampleModel

object DataMapper {

    fun mapResponseToModel(response: List<DataSampleResponse>) : List<DataSampleModel> {
        return response.map {
            DataSampleModel(it.id, it.name)
        }
    }

    fun mapEntityToModel(entity: List<DataSampleEntity>) : List<DataSampleModel> {
        return entity.map {
            DataSampleModel(it.id, it.name)
        }
    }

}