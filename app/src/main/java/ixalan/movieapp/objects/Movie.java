 package ixalan.movieapp.objects;

//A movie class for our Theatre booking app.
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;

import ixalan.movieapp.application.Services;

 public class Movie implements Serializable
{
    private int movieID; // primary key for movies (Possibly alphanumeric)
    private String Name;// The name of the movie is stored in string
    private float rating;// The rating of the movie(maybe out of 5 ) is stored as float to handle numbers like 3.8
    private String castCrew;// A list of cast members involved in the making of the movie implemented by array list but can be made an array
    private String posterUrl;// Contains a url as a string for the poster for the movie.
    private DateTime releaseDate;// The date the movie was released.
    private  String synopsis;// A brief summary of the movie.
    private String trailerUrl;// Contains a url to the trailer of the movie.
    private ArrayList<Merchandise> merchandises = new ArrayList<>();// A list of merchandises of the movie implemented by array list but can be made an array
    //We can also have a 2d array of the theater and the time the movie is playing
    private ArrayList<Theatre> theatres = new ArrayList<>();// List of theatre the movie is being payed in

    public Movie(String name, String posterUrl) {
        this.Name = name;
        this.posterUrl = posterUrl;
    }

    public Movie(String name, String posterUrl, DateTime releaseDate, ArrayList<Theatre> theatres) {
        this.Name = name;
        this.posterUrl = posterUrl;
        this.releaseDate = releaseDate;
        this.theatres = theatres;
    }

    public Movie(int movieID, String name)
    {
        this.movieID = movieID;
        this.Name = name;
    }

    public Movie(String name, String posterUrl, DateTime releaseDate, String synopsis, String trailerUrl)
    {
        this.Name =name;
        this.posterUrl = posterUrl;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.trailerUrl = trailerUrl;
    }

    public Movie(String name, String posterUrl, DateTime releaseDate, ArrayList<Theatre> theatres, String synopsis, String trailerUrl)
    {
        this.Name = name;
        this.posterUrl = posterUrl;
        this.releaseDate = releaseDate;
        this.theatres = theatres;
        this.synopsis = synopsis;
        this.trailerUrl = trailerUrl;
    }


    public ArrayList<Theatre> getTheatres() {
        return this.theatres;
    }

    public boolean isUpcoming()
    {
        //Upcoming if it has a future release date
        DateTime today = new DateTime(System.currentTimeMillis());
        releaseDate.isAfter(today);
        return releaseDate != null && releaseDate.isAfter(today);
    }

    public boolean isCurrentlyRunning()
    {
        DateTime today = new DateTime(System.currentTimeMillis());
        return !isUpcoming() && theatres != null && theatres.size() > 0 &&
                (releaseDate.isBefore(today) || releaseDate.compareTo(today) == 0);

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

    public DateTime getReleaseDate()
    {
        return this.releaseDate;
    }

    public float getRating()
    {
        return this.rating;
    }

    public String getCastCrew()
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

    public void setMovieID(int movieID){ this.movieID = movieID;}

    public void setRating(float rating)
    {
        this.rating = rating;
    }

    public void setCastCrew(String castCrew)
    {
        this.castCrew = castCrew;
    }

    public void setSynopsis(String synopsis)
    {
        this.synopsis = synopsis;
    }

    public void setMerchandiseList(ArrayList<Merchandise> merchandises)
    {
        this.merchandises = merchandises;
    }

    public void setTheatres(ArrayList<Theatre> theatres)
    {
        this.theatres = theatres;
    }

    /*public void setTheatreList(String bitmask)
    {
        if (bitmask != null)
        {
            for (int i = 0 ; i < bitmask.length() ; i++)
            {
                if (bitmask.charAt(i) == '1')
                {
                    Theatre theatre = Services.getiTheatreDB().getTheatre(i);
                    if (theatre != null)
                    {
                        theatres.add(theatre);
                    }
                }
            }
        }
    }*/

    public boolean equals(Movie movie)
    {
        return movie != null && movie.getMovieID() == this.getMovieID();
    }
}
