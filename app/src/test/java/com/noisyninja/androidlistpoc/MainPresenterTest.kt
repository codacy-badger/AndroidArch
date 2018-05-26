package com.noisyninja.androidlistpoc

import com.noisyninja.androidlistpoc.layers.di.NinjaComponent
import com.noisyninja.androidlistpoc.model.Me
import com.noisyninja.androidlistpoc.views.MainActivity
import com.noisyninja.androidlistpoc.views.MainPresenter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainPresenterTest {

    private var mainPresenter: MainPresenter? = null
    @Mock
    private val iMainActivity: MainActivity? = null
    @Mock
    private val ninjaComponent: NinjaComponent? = null
    @Mock
    private val me: Me? = null
    var arrayList = ArrayList<Me>()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        arrayList.add(me!!)
        arrayList.add(me!!)
        arrayList.add(me!!)
        arrayList.add(me!!)
        arrayList.add(me!!)
    }


    @Test
    fun makeGridLayoutTest() {
    }

}