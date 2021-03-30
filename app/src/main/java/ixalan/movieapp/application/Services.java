package ixalan.movieapp.application;

import android.content.Context;

//import org.hsqldb.*;

import ixalan.movieapp.data.FakeMerchandiseDB;
import ixalan.movieapp.data.FakeMovieDB;
import ixalan.movieapp.data.FakePosterDB;
import ixalan.movieapp.data.FakeUserDB;
import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.data.IPosterDB;
import ixalan.movieapp.data.IUserDB;
import ixalan.movieapp.data.MovieDB;
import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.objects.Theatre;

import java.io.File;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Services
{
    private static IMovieDB iMovieDB = null;
    private static IPosterDB iPosterDB = null;
    private static IUserDB iUserDB = null;
    private static IMerchandiseDB iMerchandiseDB = null;

    public static synchronized IMovieDB getiMovieDB()
    {
        if(iMovieDB == null)
        {
            //TODO: HSQLDB is still giving issues (driver not found error). Must be fixed for It 3
            //iMovieDB = new MovieDB(Main.getDBPathName());

            iMovieDB = new FakeMovieDB();
            initMovieDB();

        }

        return iMovieDB;
    }

    public static synchronized IPosterDB getiPosterDB()
    {
        if(iPosterDB == null) {
            iPosterDB = new FakePosterDB();
        }

        return iPosterDB;
    }

    public static synchronized IUserDB getiUserDB()
    {
        if(iUserDB == null) {
            iUserDB= new FakeUserDB();
        }

        return iUserDB;
    }

    public static synchronized IMerchandiseDB getiMerchandiseDB()
    {
        if(iMerchandiseDB == null) {
            iMerchandiseDB= new FakeMerchandiseDB();
        }

        return iMerchandiseDB;
    }

    private static void initMovieDB()
    {
        Calendar cal = Calendar.getInstance();

        ArrayList<Theatre> list_of_theatres = new ArrayList<Theatre>();
        list_of_theatres.add(new Theatre());
        ArrayList<Theatre> empty_list = null;

        //One movie where release date is same as today
        iMovieDB.addMovie(new Movie("Avengers Endgame","poster_1", cal.getTime(), list_of_theatres, "Cast: Chris Evans, Chris Hemsworth, Jeremy Renner, Robert Downey Jr.\nDirectors: Joe Russo, Anthony Russo\n", "TcMBFSGVi1c&ab"));

        //One movie where release date is before today
        cal.set(2021, Calendar.FEBRUARY, 13);
        iMovieDB.addMovie(new Movie("Replicas","poster_4", cal.getTime(), list_of_theatres, "Cast: Keanu Reeves\nDirector: Jeffrey Nachmanoff", "JAHKQPBKSZ8&ab"));

        //One movie where release date is after today
        cal.set(2021, Calendar.MAY, 13);
        iMovieDB.addMovie(new Movie("The Nightingale","poster_3", cal.getTime(), list_of_theatres, (String) "Cast: Aisling Franciosi\nDirector: Jennifer Kent\n", "YuP8g_GQIgI&ab"));
    }
}
