package com.noisyninja.androidlistpoc

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

/**
 * Custom test runner to mock Dagger injections via TestApplication
 * Created by sudiptadutta on 20/05/18.
 */
class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApplication::class.java.canonicalName, context)
    }
}