package com.noisyninja.androidlistpoc.modules

import android.support.test.runner.AndroidJUnit4
import com.noisyninja.androidlistpoc.BuildConfig
import com.noisyninja.androidlistpoc.layers.network.*
import com.noisyninja.androidlistpoc.model.MeResponse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyObject
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.any
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit

/**
 * Created by sudiptadutta on 23/05/18.
 */

@RunWith(AndroidJUnit4::class)
class NetworkModuleTest {
    @Mock
    lateinit var networkModule: NetworkModule
    @Mock
    lateinit var mHttpClient: HttpClient

    private val callback = object : ICallback<MeResponse> {
        override fun onSuccess(result: MeResponse?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onError(t: Throwable?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
/*
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        networkModule = NetworkModule(mHttpClient)

        Mockito.`when`(networkModule.getPeople(anyObject(),anyObject(),anyObject(),anyObject()))
                .thenReturn(GenericObserver(callback))
    }

    @Test
    fun getPeopleTest() {
        networkModule.getPeople(callback, 1, BuildConfig.RESULT_COUNT.toInt(), BuildConfig.NETSYNC_SEED.toInt())
        verify(mHttpClient).client
    }*/
}
