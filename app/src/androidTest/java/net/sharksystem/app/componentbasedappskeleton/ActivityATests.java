package net.sharksystem.app.componentbasedappskeleton;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import android.view.View;

import net.sharksystem.app.componentbasedappskeleton.app.ui.ComponentAActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class ActivityATests {
    @Rule
    public ActivityScenarioRule<ComponentAActivity> activityScenarioRule =
            new ActivityScenarioRule<ComponentAActivity>(ComponentAActivity.class);

    @Test
    public void useAppContext() {
        Matcher<View> buttonView = withId(R.id.button);

        //https://developer.android.com/reference/androidx/test/espresso/ViewInteraction?hl=en
//        ViewInteraction buttonInteraction = onView(buttonView).perform(click());
        ViewInteraction buttonInteraction = onView(buttonView);
        buttonInteraction.perform(click());

        // check result - must be a 0 after first click
        buttonInteraction.check(matches(withText("0")));

        // another click
        buttonInteraction.perform(click());
        buttonInteraction.check(matches(withText("1")));
    }
}
