//A movie class for our Theatre booking app. 
import java.util.ArrayList;
public class Movie{
    String movieID; // primary key for movies
    String Name;// The name of the movie is stored in string
    float raitng;// The rating of the movie(maybe out of 5 ) is stored as flot to handle numbers like 3.8
    ArrayList<String> castCrew = new ArrayList<>();// A list of cast members involved in the making of the movie implemented by array list but can be made an array
    String posterUrl;// Contains a url as a string for the poster for the movie. 
    String releaseDate;// The date the movie was released. 
    String synopsis;// A brief summary of the movie.
    String trailerUrl;// Contains a url to tge trailer of the movie.
    ArrayList<Merchandise> merchendises = new ArrayList<>();// A list of merchendises of the movie implemented by array list but can be made an array
    //We can also have a 2d array of the theater and the time the movie is playing 
    ArrayList<Theatre> theatres = new ArrayList<>();// List of theatre the movie is being payed in 

}