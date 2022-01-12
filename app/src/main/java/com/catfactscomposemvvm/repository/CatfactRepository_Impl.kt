package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Breed
import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.network.*

class CatfactRepository_Impl (private val catfactService: CatfactService) : CatfactRepository {
    override suspend fun getCatfact(): Catfact {
        return catfactService.getCatfact().toCatfact()
    }

    override suspend fun getCatFacts(page: Int): List<Catfact> {
        return catfactService.getCatfacts(page).toCatfacts()
    }

    override suspend fun getBreeds(page: Int): List<Breed> {
        return catfactService.getBreeds(page).toBreed()
    }

}