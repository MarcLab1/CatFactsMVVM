package com.catfactscomposemvvm.network

import retrofit2.http.GET

interface RetrofitService {

    @GET("/fact")
    suspend fun getCatfact() : CatfactDto

}