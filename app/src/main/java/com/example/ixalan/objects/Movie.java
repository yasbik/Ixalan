package com.example.ixalan.objects;

//A movie class for our Theatre booking app.
import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
public class Movie implements Serializable
{
    private int movieID; // primary key for movies (Possibly alphanumeric)
    private String Name;// The name of the movie is stored in string
    private float rating;// The rating of the movie(maybe out of 5 ) is stored as float to handle numbers like 3.8
    private ArrayList<String> castCrew = new ArrayList<>();// A list of cast members involved in the making of the movie implemented by array list but can be made an array
    private String posterUrl;// Contains a url as a string for the poster for the movie.
    private LocalDate releaseDate;// The date the movie was released.
    private  String synopsis;// A brief summary of the movie.
    private String trailerUrl;// Contains a url to the trailer of the movie.
    private ArrayList<Merchandise> merchandises = new ArrayList<>();// A list of merchandises of the movie implemented by array list but can be made an array
    //We can also have a 2d array of the theater and the time the movie is playing 
    private ArrayList<Theatre> theatres = new ArrayList<>();// List of theatre the movie is being payed in

    public Movie(String name, String posterUrl)
    {
        this.Name = name;
        this.posterUrl = posterUrl;
    }

    public boolean isUpcoming()
    {
        return releaseDate.isAfter(LocalDate.now());
    }

    public boolean isCurrentlyRunning()
    {
        return theatres != null && theatres.size() > 0 &&
                (releaseDate.isBefore(LocalDate.now()) || releaseDate.isEqual(LocalDate.now()));
    }

    public ArrayList<Theatre> getTheatres() {
        return this.theatres;
    }

    public ArrayList<Merchandise> getMerchandises() {
        return this.merchandises;
    }

    public String getSynopsis()
    {
        return this.synopsis;
    }

    public String getTrailerUrl()
    {
        return this.trailerUrl;
    }

    public LocalDate getReleaseDate()
    {
        return this.releaseDate;
    }

    public float getRating()
    {
        return this.rating;
    }

    public ArrayList<String> getCastCrew()
    {
        return this.castCrew;
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