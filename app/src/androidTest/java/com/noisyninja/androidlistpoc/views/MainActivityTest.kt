package com.noisyninja.androidlistpoc.views

import android.content.Context
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras
import android.support.test.espresso.intent.matcher.IntentMatchers.hasFlag
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.TestApplication
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito.verify

/**
 * Created by sudiptadutta on 18/05/18.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = IntentsTestRule(MainActivity::class.java)
    lateinit var context: Context
    lateinit var app: TestApplication
    lateinit var mainActivity: MainActivity
    lateinit var mainPresenter: MainPresenter

    @Before
    fun setup() {
        context = InstrumentationRegistry.getTargetContext()
        app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        mainActivity = mActivityTestRule.activity
        mainPresenter = mainActivity.mIMainPresenter as MainPresenter

        mActivityTestRule.launchActivity(null)
    }

    @Test
    fun testGetListCalled() {
        /*val recyclerView = onView(
                allOf(withId(R.id.recyclerList)))
        sleepShort()
        recyclerView.perform(actionOnItemAtPosition<StickyHeaderGridAdapter.ViewHolder>(1, click()))
        verify(mainPresenter).showDetail(Matchers.any())*/
    }

    /**
     * test if sort button is displayed and clickable, then click
     */
    @Test
    fun sortButtonTest() {
        onView(withId(R.id.fab)).check(matches(isDisplayed())).check(matches(isClickable())).perform(click())
    }

    /**
     * test if first element displayed
     */
    @Test
    fun clickFirstEntryTest() {
        val recyclerView = onView(
                allOf(withId(R.id.recyclerList)))
        sleepShort()
        recyclerView.perform(actionOnItemAtPosition<StickyHeaderGridAdapter.ViewHolder>(1, click()))

        Intents.intended(allOf(
                //hasAction(equalTo(Intent.ACTION_VIEW)),
                //hasCategories(hasItem(equalTo(Intent.CATEGORY_BROWSABLE))),
                //hasData(hasHost(equalTo("www.google.com"))),
                hasFlag(Intent.FLAG_ACTIVITY_NEW_TASK),
                hasExtras(allOf(
                        hasEntry(equalTo(context.getString(R.string.user_id_key)), any(String::class.java)))),
                IntentMatchers.hasComponent(DetailActivity::class.java.canonicalName)))
    }

}
