package ixalan.movieapp;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.presentation.MovieListActivity;
import ixalan.movieapp.presentation.ViewCartActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
    System tests relating to Feature #30: Merchandise

    Number of tests:
    Number of user stories under all features: 1
*/
public class MerchandiseTest
{

    @Rule
    public ActivityTestRule<MovieListActivity> activityRule = new ActivityTestRule<>(MovieListActivity.class);

    private ArrayList<Merchandise> merchandise;

    @Before
    public void setUp()
    {
        //initialize to get just avengers merch
        merchandise = Services.getiMerchandiseDB().getMerchandiseForMovie(1);

        //Initialize so that merchandise is showing
        onView(withId(R.id.sample_movie_button_id)).perform(click());
        onView(withId(R.id.view_merchandise_button)).perform(click());
    }

    @Test
    /*
    The purpose of this test is to check that all fields are displayed properly on the screen

    * (Verification #1) Verify that the merchandise details are displaying in the fields
    * (Action #1) Click the next button
    * (Verification #2) Verify that the details of the next item are displayed
    */
    public void test1()
    {
        System.out.println("\nStarting MerchandiseTest System Test test1\n");

        //Verification #1
        onView(withId(R.id.merchandise_item_title)).check(matches(withText(merchandise.get(0).getName())));
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring(""+merchandise.get(0).getPrice())));
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring(merchandise.get(0).getDescription())));

        //Action #1
        onView(withId(R.id.showNextButton)).perform(click());

        //Verification #1
        onView(withId(R.id.merchandise_item_title)).check(matches(withText(merchandise.get(1).getName())));
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring(""+merchandise.get(1).getPrice())));
        onView(withId(R.id.merch_details_textView)).check(matches(withSubstring(merchandise.get(1).getDescription())));

        System.out.println("\nFinished MerchandiseTest System Test test1\n");
    }

    @Test
    /*
    The purpose of this test is to check that the quantities always remain within sensible limits.
    It also checks the functionality of add and remove quantity buttons

    * (Verification #1) To begin with, quantity must be at zero.
    * (Action #1) Click the add button once
    * (Verification #2) The quantity display must be one (Test regular increment)
    * (Action #2) Click the next button
    * (Verification #3) Quantity must be zero (Test quantity reset if item is changed)
    * (Action #3) Click the remove button 4 times
    * (Verification #3) The quantity display must be zero. (Test quantity doesn't go negative)
    * (Action #4) Click the add button 11 times
    * (Verification #4) Upon the 11th time, a popup saying out of stock must display. (Test quantity doesn't go beyond what is available in stock)
    * (Action #5) Click Back / OK
    * (Verification #5) The quantity display must be 10.
    */
    public void test2()
    {
        System.out.println("\nStarting MerchandiseTest System Test Quantities\n");

        //Verification #1
        onView(withId(R.id.displayQty)).check(matches(withText("0")));

        //Action #1
        onView(withId(R.id.addQty)).perform(click());

        //Verification #2
        onView(withId(R.id.displayQty)).check(matches(withText("1")));

        //Action #2
        onView(withId(R.id.showNextButton)).perform(click());

        //Verification #3
        onView(withId(R.id.displayQty)).check(matches(withText("0")));

        //Action #3
        onView(withId(R.id.rmvQty)).perform(doubleClick());
        onView(withId(R.id.rmvQty)).perform(doubleClick());

        //Verification #4
        onView(withId(R.id.displayQty)).check(matches(withText("0")));

        //Action #4
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addQty)).perform(click());

        //Verification #4
        onView(withText("Out of stock!"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));

        //Action #5
        onView(withText("OK")).perform(click());

        //Verification #5
        onView(withId(R.id.displayQty)).check(matches(withText("10")));
    }

    @Test
    /*
    The purpose of this test is to test that merchandise items get properly added to the cart

    * (Action #1) Click Add to Cart followed by view cart
    * (Verification #1) No item should be added (test if quantity is set to zero, no quantity is added)
    * (Action #2) Click Back and increase the quantity to 2 and then click add to cart.
    * (Verification #2) A verification message saying the items were added must be displayed
    * (Action #3) Click OK followed by view cart
    * (Verification #3) The item along with the quantity 2 must be displayed on screen
    */
    public void test3()
    {
        System.out.println("\nStarting MerchandiseTest System Test Adding to cart\n");

        //Action #1
        onView(withId(R.id.addToCartButton)).perform(click());
        onView(withId(R.id.view_cart_button)).perform(click());

        //Verification #1
        onView(withId(R.id.sample_merch_button_id)).check(doesNotExist());

        //Action #2
        Espresso.pressBack();
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addToCartButton)).perform(click());

        //Verification #2
        onView(withText("You now have 2 of these items in cart"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));

        //Action #3
        onView(withText("OK")).perform(click());
        onView(withId(R.id.view_cart_button)).perform(click());

        //Verification #3
        onView(withId(R.id.sample_merch_button_id)).perform(click());
        onView(withId(R.id.sample_merch_button_id)).check(matches(withSubstring("Avengers Endgame")));
        onView(withId(R.id.sample_merch_button_id)).check(matches(withSubstring("Qty: 2")));

        System.out.println("\nSFinished MerchandiseTest System Test Adding to cart\n");
    }
}
