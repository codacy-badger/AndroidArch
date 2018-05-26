package com.noisyninja.androidlistpoc.layers.di

import android.content.Context
import android.content.res.Resources
import com.noisyninja.androidlistpoc.NinjaApp
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.DataBaseModule
import com.noisyninja.androidlistpoc.layers.database.viewmodel.ViewModelFactory
import com.noisyninja.androidlistpoc.layers.network.HttpClient
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * module containing dependency modules
 * Created by sudiptadutta on 27/04/18.
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(dataBaseModule: DataBaseModule,
                                utilModule: UtilModule,
                                resources: Resources,
                                networkModule: NetworkModule): ViewModelFactory {
        return ViewModelFactory(dataBaseModule,utilModule, resources, networkModule)
    }

    @Provides
    @Singleton
    fun provideRetrofit(context: Context, utilModule: UtilModule): Retrofit {
        return HttpClient(context, utilModule).client
    }

    @Provides
    @Singleton
    fun provideNetwork(retrofit: Retrofit): NetworkModule {
        return NetworkModule(retrofit)
    }

    @Provides
    @Singleton
    fun provideDataBase(utilModule: UtilModule, application: NinjaApp): DataBaseModule {
        return DataBaseModule(utilModule, application)
    }

}