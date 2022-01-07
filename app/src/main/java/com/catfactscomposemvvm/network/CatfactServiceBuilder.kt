package com.catfactscomposemvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatfactServiceBuilder {

    val BASE_URL = "https://catfact.ninja"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getCatfactService(): CatfactService
    {
        val retrofit = getRetrofit()
        return retrofit.create(CatfactService::class.java)
    }
}