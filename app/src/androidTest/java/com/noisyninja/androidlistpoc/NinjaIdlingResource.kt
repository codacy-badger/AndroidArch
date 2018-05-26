package com.noisyninja.androidlistpoc

import android.support.test.espresso.IdlingResource
import android.support.v4.app.FragmentManager

/**
 * Idling resource to deal with asynchronous calls and waiting
 * Created by sudiptadutta on 20/05/18.
 */

class NinjaIdlingResource(private val manager: FragmentManager, private val tag: String) : IdlingResource {

    override fun getName(): String {
        return NinjaIdlingResource::class.java.name + ":" + tag
    }

    override fun isIdleNow(): Boolean {
        val idle = (manager.findFragmentByTag(tag) == null)
        if (idle) {
            callback?.onTransitionToIdle()
        }
        return idle
    }

    private var callback: IdlingResource.ResourceCallback? = null

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.callback = callback
    }
}