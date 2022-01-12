package com.catfactscomposemvvm.network

import retrofit2.http.GET
import retrofit2.http.Query

interface CatfactService {

    @GET("/fact")
    suspend fun getCatfact() : CatfactDto

    @GET("/facts")
    suspend fun getCatfacts(
        @Query("page") page: Int
    ): CatfactsDto

    @GET("/breeds")
    suspend fun getBreeds(
        @Query("page") page: Int
    ): BreedsDto
}