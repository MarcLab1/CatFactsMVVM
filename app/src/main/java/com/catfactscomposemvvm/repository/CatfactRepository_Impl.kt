package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.network.CatfactService
import com.catfactscomposemvvm.network.toCatfact
import com.catfactscomposemvvm.network.toCatfacts
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


class CatfactRepository_Impl (private val catfactService: CatfactService) : CatfactRepository {
    override suspend fun getCatfact(): Catfact {
        return catfactService.getCatfact().toCatfact()
    }

    override suspend fun getCatFacts(): List<Catfact> {
        return catfactService.getCatfacts().toCatfacts()
    }

}