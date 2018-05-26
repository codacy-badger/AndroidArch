package com.noisyninja.androidlistpoc.views

import android.support.test.InstrumentationRegistry
import com.noisyninja.androidlistpoc.TestApplication
import com.noisyninja.androidlistpoc.layers.di.DaggerNinjaComponent
import org.mockito.Mockito
import java.time.Clock

/**
 * Base test to hold common test code
 * Created by sudiptadutta on 18/05/18.
 */

open class BaseTest {

    fun sleepShort() {
        try {
            Thread.sleep(SHORT.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    fun sleepMedium() {
        try {
            Thread.sleep(MEDIUM.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    fun sleepLong() {
        try {
            Thread.sleep(LONG.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    companion object {

        val SHORT = 1000
        val MEDIUM = 5000
        val LONG = 20000
    }
}
