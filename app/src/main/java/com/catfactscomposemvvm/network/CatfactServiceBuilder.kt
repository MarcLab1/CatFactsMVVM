package com.catfactscomposemvvm.network

import com.catfactscomposemvvm.ulits.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatfactServiceBuilder {

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