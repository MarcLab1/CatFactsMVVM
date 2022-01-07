package com.catfactscomposemvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {

    val BASE_URL = "https://catfact.ninja"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitService(): RetrofitService
    {
        val retrofit = getRetrofit()
        return retrofit.create(RetrofitService::class.java)
    }
}