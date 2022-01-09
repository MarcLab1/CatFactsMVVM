package com.catfactscomposemvvm.di

import android.content.Context
import com.catfactscomposemvvm.BaseApplication
import com.catfactscomposemvvm.network.CatfactService
import com.catfactscomposemvvm.repository.CatfactRepository
import com.catfactscomposemvvm.repository.CatfactRepository_Impl
import com.catfactscomposemvvm.ui.presentation.hilttesting.Item
import com.catfactscomposemvvm.ui.presentation.hilty.Repo
import com.catfactscomposemvvm.ui.presentation.hilty.Service
import com.catfactscomposemvvm.ulits.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    //We inject this into the VM
    @Singleton
    @Provides
    fun provideCatfactRepository(catfactService: CatfactService): CatfactRepository {
        return CatfactRepository_Impl(catfactService)
    }

    @Singleton
    @Provides
    fun provideCatfactService(): CatfactService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatfactService::class.java)
    }

    @Singleton
    @Provides
    @Named("item1")
    fun provideItem1(): Item {
        return Item()
    }


    @Singleton
    @Provides
    @Named("item2")
    fun provideItem2(): Item {
        return provideItem1()
    }

    @Singleton
    @Provides
    fun provideService() : Service
    {
        return Service("fake", 22)
    }

    @Singleton
    @Provides
    @Named("repo1")
    fun provideRepo1(service: Service) : Repo
    {
        return Repo(service)
    }

    @Singleton
    @Provides
    @Named("repo2")
    fun provideRepo2(service: Service) : Repo
    {
        return provideRepo1(provideService())
    }

}