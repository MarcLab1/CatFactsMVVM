package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Breed
import com.catfactscomposemvvm.domain.Breeds
import com.catfactscomposemvvm.domain.Catfact

interface CatfactRepository{

    suspend fun getCatfact() : Catfact

    suspend fun getCatFacts(page: Int): List<Catfact>

    suspend fun getBreeds(page: Int): List<Breed>

}