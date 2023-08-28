package com.example.proyecto_final_v2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class MainActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule (MainActivity::class.java)


    @Test
    fun testTextComparison() {
        val text1 = "Hola"
        val text2 = "Hola"

        onView(withId(R.id.editText1)).perform(typeText(text1))
        onView(withId(R.id.editText2)).perform(typeText(text2))
        onView(withId(R.id.compareButton)).perform(click())

        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son iguales")))
    }
}
