package com.noisyninja.androidlistpoc.modules

import android.support.test.runner.AndroidJUnit4
import com.noisyninja.androidlistpoc.layers.network.HttpClient
import com.noisyninja.androidlistpoc.layers.network.ICallback
import com.noisyninja.androidlistpoc.layers.network.NetworkModule
import com.noisyninja.androidlistpoc.model.MeResponse
import org.junit.runner.RunWith
import org.mockito.Mock

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
