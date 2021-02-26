Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Tell the story of how one of your features was added to the project. Provide links to the feature, user stories, and merge requests (if used), associated tests, and merge committhat was used complete the feature.
Use one or two paragraphs which can have point-form within them.

The UI based feature that we targeted for iteration 1 was for a user to be able to see what movies are being shown currently, filter movies, and look up movies. Find the feature details [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/1). This feature had three user stories linked to it:

* [Look up movies](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/4)
* [Filter movies](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/3)
* [See what movies are on](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/issues/2)

Exceptional code
----------------

Provide a link to a test of exceptional code. In a few sentences,
provide an explanation of why the exception is handled or thrown
in the code you are testing.

The test of exceptional code can be found [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/test/java/com/example/ixalan/objects/MovieTest.java)
The exception is added to the test 'testMovie2'.
The java class 'Movie' has an instance variable named 'movieID' which is not set yet for any added movies to the database. Therefore,
the movieID of every movie is same(it is 0). When two movies have same movieID, an exception 'InvalidMovieIDException' is thrown since
two IDs cannot be same.

Branching
----------

Provide a link to where you describe your branching strategy.
Provide screen shot of a feature being added using your branching strategy
successfully. The [GitLab Graph tool can do this](https://code.cs.umanitoba.ca/comp3350-summer2019/cook-eBook/-/network/develop),
as well as using `git log --graph`.

Our branching strategy is described [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/Branching_Strategy.md).

A screenshot of the targeted iteration 1 feature can be found [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/network/master)

SOLID
-----

Find a SOLID violation in the project of group `(n%12)+1` (group 12 does group 1). Open an issue in their project with the violation, clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure
your links in the issues are to **specific commits** (not to `main`, or `develop` as those will be changed).
Provide a link to the issue you created here.

We looked for SOLID violations in Group 4.


Agile Planning
--------------

Write a paragraph about any plans that were changed. Did you 'push' any features to iteration 2? Did you change the description of any Features or User Stories? Have links to any changed or pushed Features or User Stories.

During iteration 1, the plan for what had to be completed for iteration 1 did not change. The single feature we had aimed to get done for iteration 1 was completed. What we did change during iteration 1 was, we dropped the implementation of apple and android pay that we had initially talked about.
