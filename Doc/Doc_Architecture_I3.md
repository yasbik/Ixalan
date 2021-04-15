## User Interface Layer
----
[Movie Detail Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/presentation/MovieDetailActivity.java)
* Display movies currently in theatres

[Movie List Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/presentation/MovieListActivity.java)
* Displaying filtered movie to the User

[Card Payment Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/CardPaymentActivity.java)
* Displaying payment activity

[Movie Location Acctivity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/MovieLocationActivity.java)
* Displaying activity relating to locations movies can be watched

[Movie Seating Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/MovieSeatingActivity.java)
* Displaying seating arrangements

[Payment Options Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/PaymentOptionsActivity.java)
* Displaying options for payments

[Payment Successful Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/PaymentSuccessfulActivity.java)
* Displaying successful payment

[Viewing Cart Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/ViewCartActivity.java)
* Displaying what's on the cart

[Login Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/LoginActivity.java)
* Displaying the login functionality

[Movie Merchandise Activity](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/presentation/MovieMerchandiseActivity.java)
* Displaying the merchandise for movies




## Logic/Business Layer
---
[Access Movies](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/business/AccessMovies.java)
* Accessing the Database which is just used for the movies database at the moment

[Access Cart](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/business/AccessCart.java)
* Accessing the Database which is used to interact with the cart

[Access Merchandise](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/business/AccessMerchandise.java)
* Accessing the Database which is used to store the merchandise

[Access Movie Detail](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/business/AccessMovieDetail.java)
* Accessing the Database which is used to store the details of the movie



## Data Layer
---
[Fake Movies Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/FakeMovieDB.java)
* Fake Movies database to store movies

[Fake Posters Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/FakePosterDB.java)
* Fake Posters database to store the movies posters and its ID to keep track

[Fake Merchandise Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/FakePosterDB.java)
* Fake Merchandise database to store movie merchandise

[User Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/data/UserDB.java)
* The class implementation for the User database 

[Movie Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/data/MovieDB.java)
* The class implementation for the Movie database 

[Merchandise Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/data/MerchandiseDB.java)
* The class implementation for the Merchandise database 

[Theatre Database](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/data/TheatreDB.java)
* The class implementation for the Theatre database 

[Movies Database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/IMovieDB.java)
* An Interface define the functions that need to be in the Movie Database

[User Database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/IUserDB.java)
* An Interface define the functions that need to be in the User Database

[User Database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/com/example/ixalan/data/IPosterDB.java)
* An Interface define the functions that need to be in the Poster Database

[Theatre Database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/data/ITheatreDB.java)
* An Interface define the functions that need to be in the Theatre Database

[Poster Database Interface](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/data/IPosterDB.java)
* An Interface define the functions that needed to implement the posters for movies

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

[CartItem](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-3/-/blob/master/app/src/main/java/ixalan/movieapp/objects/CartItem.java)
* The CartItem object class that defines the specific item in the cart

---
