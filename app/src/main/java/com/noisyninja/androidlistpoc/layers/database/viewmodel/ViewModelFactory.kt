package com.noisyninja.androidlistpoc.layers.database.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.res.Resources
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.DataBaseModule
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import javax.inject.Inject

/**
 * View model factory to provide viewmodels for different types
 * Created by sudiptadutta on 10/05/18.
 */

open class ViewModelFactory @Inject constructor(val dataBaseModule: DataBaseModule,
                                           val utilModule: UtilModule,
                                           val resources: Resources,
                                           val networkModule: NetworkModule) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MeViewModel::class.java)) {
            return MeViewModel(dataBaseModule,
                    utilModule,
                    resources,
                    networkModule) as T
        }

        throw  IllegalArgumentException(resources.getString(R.string.unknownVMClass))
    }
}
