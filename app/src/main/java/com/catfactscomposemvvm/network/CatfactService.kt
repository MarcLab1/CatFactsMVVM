package com.catfactscomposemvvm.network

import retrofit2.http.GET

interface CatfactService {

    @GET("/fact")
    suspend fun getCatfact() : CatfactDto

    @GET("facts")
    suspend fun getCatfacts() : List<CatfactDto>

}