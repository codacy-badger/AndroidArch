package com.noisyninja.androidlistpoc

import android.content.Context
import com.noisyninja.androidlistpoc.model.Me
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UtilModuleTest : BaseUnit() {

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        setUpMocks()
        setupReturns()
    }

    /**
     * test for network availability
     */
    @Test
    fun isNetworkConnectedTest() {
        Assert.assertEquals(utilModule.isNetworkConnected, true)
        verify(context).getSystemService(Context.CONNECTIVITY_SERVICE)
    }

    /**
     * 1.test getString returns mock_string,
     * 2.check context.getString is called
     */
    @Test
    fun getStringResTest() {
        Assert.assertEquals(utilModule.getStringRes(R.string.userId), mock_string)
        verify(context).getString(R.string.userId)
    }

    /**
     * check for json marshalling
     */
    @Test
    fun toJsonTest() {
        val json = utilModule.toJson(me1)
        Assert.assertNotNull(json)
    }

    /**
     * check for json un-marshalling
     */
    @Test
    fun fromJsonTest() {
        val json = utilModule.toJson(me1)
        Assert.assertEquals(me1.name.first, utilModule.fromJson(json, Me::class.java).name.first)
    }
}
