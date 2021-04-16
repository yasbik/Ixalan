What technical debt has been cleaned up
========================================

**Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.**

The first technical debt that we paid off is that we addressed and fixed the code smells we had in our project. We would classify this debt as reckless and prudent.

The links to those issues are given below:

* [SRP violation Database in Application](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/49)

* [Non-cide in source code](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/50)

* [SRP violation](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/48)

* [OCP violation, payment types](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/47)



What technical debt did you leave?
==================================

**What one item would you like to fix, and can't? Anything you write will not
be marked negatively. Classify this debt.**

We wanted users to be able to view their previous booking history in our app. There would be a button what would show the details of all the booking the user made in the past. However, when implementing this button, we ran into issues and bugs with intigrating and pulling from the database. As a result, we ended up deleting the button and commenting out the code for the button implementation since it was not fully functional and would fail the tests. This technical debt would be considered reckless and prudent.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

**When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any iteration.**

A feature that was cut from our application was the implementation of an admin account. This admin account would have priviledges that other user accounts would not have. However, since we ran into issues creating a regular user, we did not have time to work on creating a separate account for an administrator. Hence, we pushed this feature to a future iteration. 

A link to this feature is as below:
* [Administrator and privileged actions](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/25)



Acceptance test/end-to-end
==========================

**Write a discussion about an end-to-end test that you wrote. What did you test,
how did you set up the test so it was not flaky? Provide a link to that test.**

One of the end-to-end tests written was to test if the movie details were displayed and if the movie trailer could be played.

The way this was tested was a particular movie was "clicked" after which, the test made sure that the details displayed on screen were the same as the movie details as it appears in the database.

The movie trailer part was tricky as it involced launching YouTube to play the trailer link.

This was tested by just checking if an intent with the appropriate URL was launched. This was checked with the URL of the associated movie from the database.

By making sure that the details displayed on screen matched what was in the database, we made sure that the test was not flaky.

Acceptance test, untestable
===============

**What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?**

Addition of new features would often cause some existing acceptance tests to break.

This is due to the fact that system test involves starting at a particular activity and assumptions like these made when writing the system tests would cause it to fail later on when another member added their code.

The payment feature was difficult to test due to the different types of payments the app supports.

Currently, the system tests only tests payment with credit card and not the other kinds.

Velocity/teamwork
=================

**Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.**

As we can see from out Velocity chart we tended to over estimate how much work we could actually get done. With the last two Iteration really suffering from the database setting use back on the work we actually had to get done. We definetly pulled together to push to get everything we wanted to get done in for their milestones. But these push did come in heavily closer to our deadlines. We probably could have pushed for a bit more work early on in the project to light the load at the back end.

![Velocity Chart](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/Doc/Velocity_Chart.png)
