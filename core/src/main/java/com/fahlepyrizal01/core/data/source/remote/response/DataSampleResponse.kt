package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataSampleResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String
)