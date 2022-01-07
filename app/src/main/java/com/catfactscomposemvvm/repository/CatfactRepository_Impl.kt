package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.network.CatfactService
import com.catfactscomposemvvm.network.toCatfact

class CatfactRepository_Impl(private val catfactService: CatfactService) : CatfactRepository {
    override suspend fun getCatfact(): Catfact {
        return catfactService.getCatfact().toCatfact()
    }

}