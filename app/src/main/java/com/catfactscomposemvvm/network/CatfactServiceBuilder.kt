package com.catfactscomposemvvm.network

import com.catfactscomposemvvm.ulits.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//I keep this object around to show how we did things before Hilt dependency injection

object CatfactServiceBuilder {

    /*
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
     */
}