package com.noisyninja.androidlistpoc

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DataBaseModuleTest : BaseRepository() {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        setUpMocks()
        //setupReturns()
        setUpRepository()
        setupLoopers()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        tearDownRepository()
        tearDownLoopers()
    }

    @Test
    fun getNotifications_IfNotificationsInserted_ReturnsAListOfNotifications() {

        databaseDao.insert(me1)

        val meList = databaseDao.all.blockingObserve()

        if (meList != null) {
            assertEquals(meList?.size, 1)
        }
    }

    /*private fun createTestNotification(id: Int): Notification {
        //method omitted for brevity
    }*/

    fun <T> LiveData<T>.blockingObserve(): T? {
        var value: T? = null
        val latch = CountDownLatch(1)
        val innerObserver = Observer<T> {
            value = it
            latch.countDown()
        }
        observeForever(innerObserver)
        latch.await(2, TimeUnit.SECONDS)
        return value
    }
}
