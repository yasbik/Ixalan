package ixalan.movieapp;


import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
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
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.presentation.MovieListActivity;
import ixalan.movieapp.presentation.ViewCartActivity;

public class PaymentTest {
    @Rule
    public ActivityTestRule<MovieListActivity> activityRule = new ActivityTestRule<>(MovieListActivity.class);

    private ArrayList<Merchandise> merchandise;

    @Before
    public void setUp() {
        //Initialize so that merchandise is showing
        onView(withId(R.id.sample_movie_button_id)).perform(click());
        onView(withId(R.id.view_merchandise_button)).perform(click());
    }

    @Test
    public void test1() {
        System.out.println("\nStarting PaymentTest System Test: CheckTotalPrice");

        //Action #1
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addToCartButton)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.view_cart_button)).perform(click());

        //Verification #1
        onView(withId(R.id.total_price_text_view)).check(matches(withText("TOTAL     $30.00")));

        System.out.println("Finished PaymentTest System Test: CheckTotalPrice");
    }

    @Test
    public void test2() {
        System.out.println("\nStarting PaymentTest System Test: ViewPaymentOptions");

        //Action #1
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addToCartButton)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.view_cart_button)).perform(click());
        onView(withId(R.id.place_order_button)).perform(click());

        //Verification #1
        onView(withId(R.id.apple_payment_button)).check(matches(withText("CONTINUE WITH APPLE")));
        //Verification #2
        onView(withId(R.id.google_payment_button)).check(matches(withText("CONTINUE WITH GOOGLE")));
        //Verification #3
        onView(withId(R.id.facebook_payment_button)).check(matches(withText("CONTINUE WITH FACEBOOK")));
        //Verification #4
        onView(withId(R.id.email_payment_button)).check(matches(withText("CONTINUE WITH EMAIL")));
        //Verification #5
        onView(withId(R.id.card_payment_button)).check(matches(withText("CONTINUE WITH CREDIT CARD")));

        System.out.println("Finished PaymentTest System Test: ViewPaymentOptions");
    }

    @Test
    public void test3() {
        System.out.println("\nStarting PaymentTest System Test: CheckCardPaymentOptions");

        //Action #1
        onView(withId(R.id.addQty)).perform(doubleClick());
        onView(withId(R.id.addToCartButton)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.view_cart_button)).perform(click());
        onView(withId(R.id.place_order_button)).perform(click());
        onView(withId(R.id.card_payment_button)).perform(click());

        //Verification #1
        onView(withId(R.id.cardpay_header_text_view)).check(matches(withSubstring("Enter Credit Card Details")));

        //Action #2
        onView(withId(R.id.card_number_text)).perform(typeText("1234567812345678"));
        onView(withId(R.id.expiry_date_text)).perform(typeText("02/23"));
        onView(withId(R.id.security_code_text)).perform(typeText("123"));
        onView(withId(R.id.card_name_text)).perform(typeText("Abc Def"));
        onView(withId(R.id.postal_code_text)).perform(typeText("R3T2N5"));
        closeSoftKeyboard();

        //Verification #2
        onView(withId(R.id.card_number_text)).check(matches(withText("1234567812345678")));
        onView(withId(R.id.expiry_date_text)).check(matches(withText("02/23")));
        onView(withId(R.id.security_code_text)).check(matches(withText("123")));
        onView(withId(R.id.card_name_text)).check(matches(withText("Abc Def")));
        onView(withId(R.id.postal_code_text)).check(matches(withText("R3T2N5")));

        //Action #3
        onView(withId(R.id.pay_button)).perform(click());

        //Verification #3
        onView(withId(R.id.payment_done_text_view)).check(matches(withText("Your payment has been successful!")));

        System.out.println("Finished PaymentTest System Test: CheckCardPaymentOptions");
    }


}
