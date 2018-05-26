package com.noisyninja.androidlistpoc

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.network.HttpClient
import com.noisyninja.androidlistpoc.layers.network.ICallback
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import com.noisyninja.androidlistpoc.model.Me
import com.noisyninja.androidlistpoc.model.MeResponse
import com.noisyninja.androidlistpoc.model.Name
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Created by sudiptadutta on 23/05/18.
 */
open class BaseUnit {

    @Mock
    lateinit var context: Context
    @Mock
    lateinit var connectivityManager: ConnectivityManager
    @Mock
    lateinit var networkInfo: NetworkInfo
    @Mock
    lateinit var httpClient: HttpClient

    lateinit var utilModule: UtilModule
    lateinit var networkModule: NetworkModule

    lateinit var me1: Me
    lateinit var me2: Me
    lateinit var me3: Me
    lateinit var me4: Me
    val page = 1

    fun setUpMocks() {
        me1 = Me(Name(mock_string))
        me2 = Me(Name(mock_string))
        me3 = Me(Name(mock_string))
        me4 = Me(Name(mock_string))

        utilModule = UtilModule(context)
        //networkModule = NetworkModule(httpClient)
    }

    fun setupReturns() {
        Mockito.`when`(context.getString(R.string.userId)).thenReturn(mock_string)
        Mockito.`when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager)
        Mockito.`when`(connectivityManager.activeNetworkInfo).thenReturn(networkInfo)
        // Mockito.`when`(httpClient.client).thenReturn(Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).build())
        // Mockito.`when`(networkModule.getPeople(networkCallback, page, BuildConfig.RESULT_COUNT.toInt(), BuildConfig.NETSYNC_SEED_VALUE.toInt())).thenReturn(GenericObserver(networkCallback))
    }

    companion object {
        val mock_string = "mock_string"
    }

    protected val networkCallback = object : ICallback<MeResponse> {
        override fun onSuccess(result: MeResponse?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onError(t: Throwable?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }


}