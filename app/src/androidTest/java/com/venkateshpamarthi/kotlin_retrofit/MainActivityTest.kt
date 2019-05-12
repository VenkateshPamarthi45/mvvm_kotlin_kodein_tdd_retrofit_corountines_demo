package com.venkateshpamarthi.kotlin_retrofit


import android.support.test.espresso.Espresso.*
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.venkateshpamarthi.kotlin_retrofit.feature_weather.ui.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkIfProgressBarIsDisplayedFirst() {
        onView(withId(R.id.progressbar)).check(matches(isDisplayed()))
    }
    @Test
    fun checkIfTextViewIsNotDisplayedOnLaunch(){
        onView(withId(R.id.text)).check(matches(not(isDisplayed())))
    }

    @Test
    fun waitForNetworkCallToCompleteAndCheckViews(){
        val mainActivityIdlingResource = mActivityTestRule.activity.countingIdlingResource
        IdlingRegistry.getInstance().register(mainActivityIdlingResource)
        onView(withId(R.id.text)).check(matches(isDisplayed()))
        onView(withId(R.id.progressbar)).check(matches(not(isDisplayed())))
        IdlingRegistry.getInstance().unregister(mainActivityIdlingResource)
    }
}
