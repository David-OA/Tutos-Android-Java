package com.example.espresso;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.AllOf.allOf;


@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public final ActivityScenarioRule<MainActivity> mainActivityActivityTestRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Before
    public void setup() throws Exception{
        //this.context = InstrumentationRegistry.getTargetContext();
    }

    /*on précise que l'on veut tester un MainActivity
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        //doit être appelé dans le setup
        getActivity();
    }*/

    @Test
    public void testContainsIntialViews() {
        //je vais tester ici que l'EditText et le bouton LOGIN sont bien affichés
        //mais que le TextView "Hello XXXX" n'est pas présent

        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withText("LOGIN")).check(matches(isDisplayed()));
        onView(withId(R.id.text)).check(matches(not(isDisplayed())));
    }

    //teste le comportement de l'écran si on appuie sur LOGIN sans avoir écrit de nom
    @Test
    public void testClickLogin_emptyText() {
        //je vais cliquer sur LOGIN, mais sans avoir écrit de texte dans l'EditText
        onView(withText("LOGIN")).perform(click());

        //Ce qui ne devrait pas cacher le bouton LOGIN, ni afficher le "Hello XXXX"
        onView(withText("LOGIN")).check(matches(isDisplayed()));
        onView(withId(R.id.text)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testClickLogin_withText() {
        //je vais écrire "florent" dans l'EditText
        onView(withId(R.id.editText)).perform(typeText("florent"));

        //puis clicker sur le bouton LOGIN
        onView(withText("LOGIN")).perform(click());

        //ce qui devrait faire disparaitre LOGIN et l'EditText
        onView(withText("LOGIN")).check(matches(not(isDisplayed())));
        onView(withId(R.id.editText)).check(matches(not(isDisplayed())));

        //puis afficher "Hello florent"
        onView(withId(R.id.text)).check(matches(allOf(isDisplayed(), withText("Hello florent"))));
    }
}
