package com.example.ixalan;
import java.util.ArrayList;

public class FakeMovieDB implements movieDBInterface{

    ArrayList<Movie> Movies;

    public FakeMovieDB(){
        Movies = new ArrayLIst<Movie>();
    }

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
        return  checkMovie;
    }

    public int removeMovie(int MovieID){
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
}