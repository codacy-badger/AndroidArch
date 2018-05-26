package com.noisyninja.androidlistpoc.layers

import android.os.Handler
import android.os.Looper
import android.support.annotation.NonNull
import java.util.concurrent.Executor
import javax.inject.Inject


/**
 * Android api thread executor
 * Created by sudiptadutta on 10/05/18.
 */
open class AppExecutors(private val diskIO: Executor, private val networkIO: Executor, private val mainThread: Executor) {

    class MainThreadExecutor @Inject constructor() : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(@NonNull command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    fun diskIO(): Executor {
        return diskIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    fun networkIO(): Executor {
        return networkIO
    }

    /*// For Singleton instantiation
    companion object {

    private val LOCK = Any()
    private var sInstance: AppExecutors? = null
        get() {
            if (sInstance == null) {
                synchronized(LOCK) {
                    sInstance = AppExecutors(Executors.newSingleThreadExecutor(),
                            Executors.newFixedThreadPool(3),
                            MainThreadExecutor())
                }
            }
            return sInstance
        }
    }*/
}