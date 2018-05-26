package com.noisyninja.androidlistpoc.modules

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.persistence.room.Room
import com.noisyninja.androidlistpoc.layers.database.IDatabase
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


abstract class BaseRepository : Base() {

    protected lateinit var mIDatabase: IDatabase

    @Before
    fun setupRepository() {
        setupEnvironment()
        setUpMocks()

        mIDatabase = Room.inMemoryDatabaseBuilder(
                context,
                IDatabase::class.java)
                .build()
    }

    @After
    @Throws(IOException::class)
    fun teardownRepository() {
        mIDatabase.close()
    }


    protected fun setupLoopers() {
        //to make sure subscribeOn and observeOn run on same thread
        //async call becomes synchronous, thus waits for response
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { scheduler -> Schedulers.trampoline() }
    }

    protected fun tearDownLoopers() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

}


/**
 * This function blocks the thread, waits for the value to be passed to observer and then returns it
 */
@Throws(InterruptedException::class)
fun <T> LiveData<T>.getValueBlocking(): T? {
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