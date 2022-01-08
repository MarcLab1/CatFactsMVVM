package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Catfact

interface CatfactRepository{

    suspend fun getCatfact() : Catfact

    suspend fun getCatFacts(): List<Catfact>

}