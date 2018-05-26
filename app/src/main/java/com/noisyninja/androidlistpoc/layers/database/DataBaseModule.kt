package com.noisyninja.androidlistpoc.layers.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.content.Context
import com.noisyninja.androidlistpoc.BuildConfig
import com.noisyninja.androidlistpoc.layers.UtilModule
import com.noisyninja.androidlistpoc.layers.Utils
import com.noisyninja.androidlistpoc.model.Me
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * databse client
 * Created by sudiptadutta on 30/04/18.
 */
open class DataBaseModule @Inject constructor(internal var mUtilModule: UtilModule, context: Context) : DatabaseDao {

    internal var mDataBase: IDatabase

    init {

        Utils.logI(this.javaClass, "DataBaseModule")
        mDataBase = Room.databaseBuilder(context,
                IDatabase::class.java, BuildConfig.APP_DB)
                //.allowMainThreadQueries() do not use!!
                .build()
    }

    override fun getAll(): LiveData<List<Me>> {

        return mDataBase.databaseDao().all
    }

    /*override fun findById(id: Int): LiveData<Me> {
        return mDataBase.databaseDao().findById(id)
    }*/

    override fun insert(me: Me?) {
        Completable.fromAction(object : Action {
            @Throws(Exception::class)
            override fun run() {
                mUtilModule.logI("inserting")
                mDataBase.databaseDao().insert(me)
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {}

            override fun onComplete() {
                mUtilModule.logI("inserting done")
            }

            override fun onError(e: Throwable) {
                mUtilModule.logI("delete error " + e.message)
            }
        })

    }

    override fun delete(me: Me?) {
        Completable.fromAction(object : Action {
            @Throws(Exception::class)
            override fun run() {
                mUtilModule.logI("deleting")
                mDataBase.databaseDao().delete(me)
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {}

            override fun onComplete() {
                mUtilModule.logI("delete done")
            }

            override fun onError(e: Throwable) {
                mUtilModule.logI("delete error " + e.message)
            }
        })
    }

    override fun insertAll(meList: List<Me>?) {
        Completable.fromAction(object : Action {
            @Throws(Exception::class)
            override fun run() {
                mUtilModule.logI("inserting")
                mDataBase.databaseDao().insertAll(meList)
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {}

            override fun onComplete() {
                mUtilModule.logI("insert done")
            }

            override fun onError(e: Throwable) {
                mUtilModule.logI("delete error " + e.message)
            }
        })
    }
}