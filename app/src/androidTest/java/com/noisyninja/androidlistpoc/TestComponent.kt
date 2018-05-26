package com.noisyninja.androidlistpoc

import android.content.Context
import android.content.res.Resources
import com.noisyninja.androidlistpoc.layers.AppExecutors
import com.noisyninja.androidlistpoc.layers.RefWatcherModule
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.DataBaseModule
import com.noisyninja.androidlistpoc.layers.database.viewmodel.ViewModelFactory
import com.noisyninja.androidlistpoc.layers.di.NinjaComponent
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import dagger.BindsInstance
import dagger.Component

/**
 * Mock dagger dependency component
 * Created by sudiptadutta on 21/05/18.
 */

@Component
interface TestComponent : NinjaComponent {

    @Component.Builder
    interface Builder {
        fun build(): TestComponent

        @BindsInstance
        fun app(ninjaApp: NinjaApp): Builder

        @BindsInstance
        fun refWatcher(refWatcherModule: RefWatcherModule): Builder

        @BindsInstance
        fun appContext(context: Context): Builder

        @BindsInstance
        fun resources(resources: Resources): Builder

        @BindsInstance
        fun network(networkModule: NetworkModule): Builder

        @BindsInstance
        fun vmf(viewModelFactory: ViewModelFactory): Builder

        @BindsInstance
        fun database(dataBaseModule: DataBaseModule): Builder

        @BindsInstance
        fun executor(appExecutors: AppExecutors): Builder

        @BindsInstance
        fun util(utilModule: UtilModule): Builder
    }

}