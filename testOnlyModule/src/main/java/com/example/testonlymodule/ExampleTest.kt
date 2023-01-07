package com.example.testonlymodule

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.intunesample.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ExampleTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun init()
    {
        hiltRule.inject()
    }

    @get:Rule(order = 1)
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        // Context of the app under test.

        activityScenarioRule.scenario.onActivity {
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.intunesample", appContext.packageName)



//            Thread.sleep(5000)
        }
        Espresso.onView(ViewMatchers.withId(com.example.intunesample.R.id.toolbar)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}