package com.noisyninja.androidlistpoc.layers.di

import android.content.Context
import com.noisyninja.androidlistpoc.NinjaApp

/**
 * injects cmponent to Application so it can be accessed from all activities
 * Created by sudiptadutta on 27/04/18.
 */

class NinjaInjector {

    var ninjaApplication: NinjaApp? = null

    val ninjaComponent: NinjaComponent
        get() = ninjaApplication!!.ninjaComponent

    fun setApplication(application: NinjaApp) {
        ninjaApplication = application
    }

    fun getNinjaComponent(context: Context): NinjaComponent =
            (context.applicationContext as NinjaApp).ninjaComponent
}