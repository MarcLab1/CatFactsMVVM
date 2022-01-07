package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.network.RetrofitService
import com.catfactscomposemvvm.network.toCatfact

class CatfactRepository (private val retrofitService: RetrofitService) {

    suspend fun getCatfact() : Catfact
    {
        return retrofitService.getCatfact().toCatfact()
    }
}