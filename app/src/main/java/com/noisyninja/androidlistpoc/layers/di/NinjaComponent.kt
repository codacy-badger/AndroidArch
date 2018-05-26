package com.noisyninja.androidlistpoc.layers.di

import android.content.Context
import android.content.res.Resources
import com.noisyninja.androidlistpoc.NinjaApp
import com.noisyninja.androidlistpoc.layers.AppExecutors
import com.noisyninja.androidlistpoc.layers.RefWatcherModule
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.DataBaseModule
import com.noisyninja.androidlistpoc.layers.database.viewmodel.ViewModelFactory
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import com.noisyninja.androidlistpoc.views.MainPresenter
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * module interface
 * Created by sudiptadutta on 27/04/18.
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, SystemModule::class, RepositoryModule::class))
interface NinjaComponent {
    fun inject(mainPresenter: MainPresenter)
    fun app(): NinjaApp
    fun refWatcher(): RefWatcherModule
    fun appContext(): Context
    fun resources(): Resources
    fun network(): NetworkModule
    fun vmf(): ViewModelFactory
    fun database(): DataBaseModule
    fun executor(): AppExecutors
    fun util(): UtilModule
}