package com.noisyninja.androidlistpoc

import android.arch.persistence.room.Room
import com.noisyninja.androidlistpoc.layers.database.DatabaseDao
import com.noisyninja.androidlistpoc.layers.database.IDatabase
import com.noisyninja.androidlistpoc.model.MeResponse
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import okhttp3.mockwebserver.MockWebServer
import java.util.*


open class BaseRepository : BaseUnit() {

    lateinit var mMockWebServer: MockWebServer
    lateinit var mSubscriber: TestObserver<MeResponse>

    lateinit var meResponse: MeResponse

    lateinit var iDatabase: IDatabase
    lateinit var databaseDao: DatabaseDao

    fun setUpRepository() {

        mMockWebServer = MockWebServer()
        mSubscriber = TestObserver()
        meResponse = MeResponse()
        meResponse.people = Arrays.asList(me1, me2, me3, me4)

        // to mock response too
        // mMockWebServer.enqueue(MockResponse().setBody(Gson().toJson(meResponse)))

        iDatabase = Room.inMemoryDatabaseBuilder(context, IDatabase::class.java).allowMainThreadQueries().build()
        databaseDao = iDatabase.databaseDao()
    }

    fun tearDownRepository() {
        iDatabase.close()
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