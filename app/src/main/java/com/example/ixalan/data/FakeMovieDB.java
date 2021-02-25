package com.example.ixalan.data;
import java.util.ArrayList;
import com.example.ixalan.object.Movie;

public class FakeMovieDB implements movieDBInterface{

    ArrayList<Movie> Movies;

    public FakeMovieDB(){
        Movies = new ArrayList<Movie>();
    }

    // searches the Movies database for the given MovieID returns NULL if not Found.
    @override
    public Movie getMovie(int movieID){
        int index=0;
        Movie checkMovie;
        int tempMovieID;
        boolean found = false;
        Movie returnedMovie = null;

        while(index < Movies.size() && !found){
            checkMovie = Movies.get(index);
            tempMovieID = checkMovie.getID();

            if(tempMovieID == movieID){
                found = true;
                returnedMovie = checkMovie;
            }
             if(found == false){
                 index++;
             }
        }
        return  returnedMovie;
    }

    // removes a Movie from the database based on it movieID and returns -1 if failed
    @override
    public int removeMovie(int movieID){
        int index=0;
        Movie checkMovie;
        int tempMovieID;
        boolean found = false;
        int successful= -1;

        while(index < Movies.size() && !found){
            checkMovie = Movies.get(index);
            tempMovieID = checkMovie.getID();

            if(tempMovieID == movieID){
                found = true;
                Movies.remove(index);
                successful = 1;
            }
            if(found == false){
                index++;
            }
        }
        return  successful;
    }

    //adds a Movie Object to the Database.
    @override
    public void addMovie(Movie newMovie){
        Movies.add(newMOvie);
    }
}