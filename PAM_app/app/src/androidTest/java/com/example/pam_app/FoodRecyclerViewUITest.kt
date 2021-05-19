package com.example.pam_app

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.example.pam_app.foodAndDrinks.RecyclerActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import java.util.*

class FoodRecyclerViewUITest {
    @get:Rule
    var activityRule = ActivityTestRule(RecyclerActivity::class.java)

    @Test
    @Throws(InterruptedException::class)
    fun testVisibilityRecyclerView() {
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    @Throws(InterruptedException::class)
    fun testCaseForRecyclerScroll() {
        Thread.sleep(1000)
        val recyclerView =
            activityRule.activity.findViewById<RecyclerView>(R.id.recyclerView)
        val itemCount =
            Objects.requireNonNull(recyclerView.adapter!!).itemCount
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemCount - 1))
    }
}