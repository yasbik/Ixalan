package com.example.ixalan.data;
import java.util.ArrayList;
import com.example.ixalan.objects.Movie;

public class FakeMovieDB implements IMovieDB{

    ArrayList<Movie> Movies;

    public FakeMovieDB(){
        Movies = new ArrayList<Movie>();
    }

    // searches the Movies database for the given MovieID returns NULL if not Found.
    @Override
    public Movie getMovie(int movieID){
        int index=0;
        Movie checkMovie;
        int tempMovieID;
        boolean found = false;
        Movie returnedMovie = null;

        while(index < Movies.size() && !found){
            checkMovie = Movies.get(index);
            tempMovieID = checkMovie.getMovieID();

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

    public ArrayList<Movie> getAllMovies()
    {
        return Movies;
    }


    // removes a Movie from the database based on it movieID and returns -1 if failed
    @Override
    public int removeMovie(int movieID){
        int index=0;
        Movie checkMovie;
        int tempMovieID;
        boolean found = false;
        int successful= -1;

        while(index < Movies.size() && !found){
            checkMovie = Movies.get(index);
            tempMovieID = checkMovie.getMovieID();

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
    @Override
    public void addMovie(Movie newMovie){
        Movies.add(newMovie);
    }
}