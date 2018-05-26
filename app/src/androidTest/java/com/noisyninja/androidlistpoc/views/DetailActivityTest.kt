package com.noisyninja.androidlistpoc.views

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.noisyninja.androidlistpoc.R
import com.noisyninja.androidlistpoc.R.id
import com.noisyninja.androidlistpoc.R.string
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by sudiptadutta on 19/05/18.
 */
@RunWith(AndroidJUnit4::class)
class DetailActivityTest : BaseTest() {

    /**
     *  launchActivity false as we are launching the activity manually in setup
     */
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(DetailActivity::class.java, true, false)
    val intent = Intent()
    val context = InstrumentationRegistry.getTargetContext()

    @Mock
    private val iDetailActivity: DetailActivity? = null

    /**
     *  launching activity with USER_ID extra in intent
     */
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        intent.putExtra(context.getString(R.string.user_id_key), context.getString(R.string.user_id_value))
        mActivityTestRule.launchActivity(intent)
    }

    /**
     * check detail text is correct
     */
    @Test
    fun testEmptyDetail() {
        onView(withId(id.detail)).check(matches(withText(string.out_of_scope)))
    }

    /**
     * to be sure loadUser method is called after setup launches activity
     */
    @Test
    fun testIntentData() {
        verify(iDetailActivity)?.loadUser(context.getString(R.string.user_id_value))
    }
}