package com.example.ixalan.objects;

//A movie class for our Theatre booking app.
import java.util.ArrayList;
public class Movie
{
    int movieID; // primary key for movies
    String Name;// The name of the movie is stored in string
    float rating;// The rating of the movie(maybe out of 5 ) is stored as float to handle numbers like 3.8
    ArrayList<String> castCrew = new ArrayList<>();// A list of cast members involved in the making of the movie implemented by array list but can be made an array
    String posterUrl;// Contains a url as a string for the poster for the movie. 
    String releaseDate;// The date the movie was released. 
    String synopsis;// A brief summary of the movie.
    String trailerUrl;// Contains a url to tge trailer of the movie.
    ArrayList<Merchandise> merchandises = new ArrayList<>();// A list of merchandises of the movie implemented by array list but can be made an array
    //We can also have a 2d array of the theater and the time the movie is playing 
    ArrayList<Theatre> theatres = new ArrayList<>();// List of theatre the movie is being payed in

    public Movie(String name, String posterUrl)
    {
        this.Name = name;
        this.posterUrl = posterUrl;
    }

    public String getMovieName()
    {
        return Name;
    }

    public String getMoviePoster()
    {
        return posterUrl;
    }

    public int getMovieID()
    {
        return this.movieID;
    }

}