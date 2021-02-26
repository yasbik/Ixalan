## User Interface Layer
----
[Movie Detail Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/presentation/MovieDetailActivity.java)
* Display movies currently in theatres

[Movie List Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/presentation/MovieListActivity.java)
* Displaying filtered movie to the User

## Logic/Business Layer
---
[Access Movies](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/business/AccessMovies.java)
* Accessing the Database which is just used for the movies database at the moment

## Data Layer
---
[Fake Movies Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/FakeMovieDB.java)
* the class implementation for the Movies database and the functions it has

[Fake Posters Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/FakePosterDB.java)
* the class implementation for the Posters database stores the movies poster and it's ID to keep track

[Fake User Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/FakeUserDB.java)
* the class implementation for the user database which is unused in iteration 1 and is currently empty.

[Movies database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/IMovieDB.java)
* an Interface define the functions that need to be in the Movie Database

[User database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/IUserDB.java)
* an Interface define the functions that need to be in the User Database

[User database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/IPosterDB.java)
* an Interface define the functions that need to be in the Poster Database

## Domain Specific Objects
---
[User](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/User.java)
* The User object that is the parent class to the Admin, Registered User, and Guest classes

[Guest](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/Guest.java)
* The Guest class that extends the User class

[Admin](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/Admin.java)
* The Admin class that is used to identify Admins and give them privilege's

[Merchandise](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/Merchandise.java)
* The Merchandise object that describes what the movie related merchandise is and price

[Movie](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/Movie.java)
* The Movie Object class

[RegiUser](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/RegiUser.java)
* The Registered user class that adds functionality to the user class

[Theatre](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/objects/Theatre.java)
* The Theatre object class that defines the specific theatre
