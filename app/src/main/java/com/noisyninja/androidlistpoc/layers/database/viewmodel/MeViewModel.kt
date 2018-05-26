package com.noisyninja.androidlistpoc.layers.database.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.res.Resources
import com.noisyninja.androidlistpoc.BuildConfig.NETSYNC_SEED_VALUE
import com.noisyninja.androidlistpoc.BuildConfig.RESULT_COUNT
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.database.DataBaseModule
import com.noisyninja.androidlistpoc.layers.network.ICallback
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import com.noisyninja.androidlistpoc.model.Me
import com.noisyninja.androidlistpoc.model.MeResponse
import com.noisyninja.androidlistpoc.model.Name
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * view model for Me pojo, also acts as the repository which syncs with network
 * and fetches from database when a connection isn't available
 * Created by sudiptadutta on 10/05/18.
 */
open class MeViewModel @Inject constructor(val dataBaseModule: DataBaseModule,
                                           val utilModule: UtilModule,
                                           val resources: Resources,
                                           val networkModule: NetworkModule) : ViewModel(), ICallback<MeResponse> {

    private var errorResponse: Me = Me(Name(resources.getString(R.string.error_net)))
    var compositeDisposables = CompositeDisposable()


    private val meLiveData: LiveData<List<Me>>

    init {
        meLiveData = dataBaseModule.all
    }

    fun hello(): Int {
        return 1
    }

    fun getMe(): LiveData<List<Me>> {

        if (meLiveData.value == null || meLiveData.value!!.isEmpty() || meLiveData.value!!.size < 2) {
            utilModule.logI("getMe network")
            compositeDisposables
                    .add(networkModule
                            .getPeople(1, RESULT_COUNT.toInt(), NETSYNC_SEED_VALUE.toInt()).subscribe(
                                    { onSuccess(it) },
                                    { onError(it) }
                            ))
        } else {
            utilModule.logI("getMe database")
        }

        return meLiveData
    }

    override fun onSuccess(result: MeResponse?) {
        utilModule.logI("net response")

        dataBaseModule.delete(errorResponse)
        dataBaseModule.insertAll(result?.people)
        dispose()

    }

    override fun onError(t: Throwable) {
        utilModule.logI("no response")
        errorResponse.name.first = t.message
        dataBaseModule.insert(errorResponse)
        dispose()
    }

    private fun dispose() {
        utilModule.logI("disposing observable")
        if (!compositeDisposables.isDisposed) {
            compositeDisposables.dispose()
        }
    }
}
