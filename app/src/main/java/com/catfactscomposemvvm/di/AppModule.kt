package com.catfactscomposemvvm.di

import android.content.Context
import com.catfactscomposemvvm.BaseApplication
import com.catfactscomposemvvm.network.CatfactService
import com.catfactscomposemvvm.repository.CatfactRepository
import com.catfactscomposemvvm.repository.CatfactRepository_Impl
import com.catfactscomposemvvm.ulits.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideCatfactRepository(): CatfactRepository {
        return CatfactRepository_Impl(provideCatfactService())
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
}