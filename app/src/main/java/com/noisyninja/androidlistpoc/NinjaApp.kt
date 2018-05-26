package com.noisyninja.androidlistpoc

import android.app.Application
import com.noisyninja.androidlistpoc.layers.RefWatcherModule
import com.noisyninja.androidlistpoc.layers.di.DaggerNinjaComponent
import com.noisyninja.androidlistpoc.layers.di.NinjaComponent
import com.noisyninja.androidlistpoc.layers.di.RepositoryModule
import com.noisyninja.androidlistpoc.layers.di.SystemModule
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

/**
 * Application subclass
 * Created by sudiptadutta on 27/04/18.
 */

open class NinjaApp : Application() {

    open val ninjaComponent: NinjaComponent by lazy {
        DaggerNinjaComponent.builder()
                .systemModule(SystemModule(this, RefWatcherModule( LeakCanary.install(this))))
                .repositoryModule(RepositoryModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        //ninjaComponent!!.inject(this)
        //NinjaInjector.setApplication(this)
        //NinjaInjector.getNinjaComponent(this).inject(this)
/*
        val intent = Intent(this, TimeoutService::class.java)
        startService(intent)
*/
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}