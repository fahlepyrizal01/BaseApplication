package com.fahlepyrizal01.core.data.source.remote.network

import com.fahlepyrizal01.core.data.source.remote.response.SampleResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE

interface ApiService {

    //region GET
    @GET("endpoint")
    suspend fun getAllData(): SampleResponse

    @GET("endpoint")
    suspend fun getOneData(@Query("id") id: String): SampleResponse
    //endregion

    //region POST
    @POST("endpoint")
    suspend fun postData(): Boolean
    //endregion

    //region PUT
    @PUT("endpoint")
    suspend fun putData(): Boolean
    //endregion

    //region PUT
    @DELETE("endpoint")
    suspend fun deleteData(): Boolean
    //endregion

}