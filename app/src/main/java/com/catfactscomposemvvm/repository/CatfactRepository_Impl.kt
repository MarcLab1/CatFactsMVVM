package com.catfactscomposemvvm.repository

import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.network.CatfactService
import com.catfactscomposemvvm.network.toCatfact
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


class CatfactRepository_Impl(private val catfactService: CatfactService) : CatfactRepository {
    override suspend fun getCatfact(): Catfact {
        return catfactService.getCatfact().toCatfact()
    }

}