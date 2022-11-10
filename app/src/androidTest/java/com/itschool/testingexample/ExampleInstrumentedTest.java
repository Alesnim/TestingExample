package com.itschool.testingexample;

import android.content.Context;

import androidx.test.espresso.IdlingPolicies;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.itschool.testingexample", appContext.getPackageName());
    }

    @Test
    public void checkTextView() {
        onView(withId(R.id.tw_text))
                .check(matches(withText(R.string.hello)));
    }


    @Test
    public void checkEditText() {

        onView(withId(R.id.ed_text))
                .perform(typeText("123"));
        onView(withId(R.id.ed_text))
                .check(matches(withText("123")));
    }


    @Test
    public void checkWork() {
        onView(withId(R.id.ed_text))
                .perform(typeText("42"), closeSoftKeyboard());

        onView(withId(R.id.bt_check))
                .perform(click());
        onView(withId(R.id.tw_text)).check(matches(withText("42")));
    }

    @Test
    public void checkEmptyClick() {
        IdlingPolicies.setMasterPolicyTimeout(120, TimeUnit.SECONDS);
        IdlingPolicies.setIdlingResourceTimeout(60, TimeUnit.SECONDS);
        onView(withId(R.id.bt_check))
                .perform(click());

        onView(withId(R.id.tw_text)).check(matches(withText("")));
    }
}