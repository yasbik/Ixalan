package com.example.ixalan.application;

import com.example.ixalan.data.FakeMovieDB;
import com.example.ixalan.data.FakePosterDB;
import com.example.ixalan.data.FakeUserDB;
import com.example.ixalan.data.IMovieDB;
import com.example.ixalan.data.IPosterDB;
import com.example.ixalan.data.IUserDB;
import com.example.ixalan.objects.Movie;
import com.example.ixalan.objects.Theatre;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Services
{
    private static IMovieDB iMovieDB = null;
    private static IPosterDB iPosterDB = null;
    private static IUserDB iUserDB = null;

    public static synchronized IMovieDB getiMovieDB()
    {
        if(iMovieDB == null)
        {
            iMovieDB = new FakeMovieDB();
        }

        return iMovieDB;
    }

    public static synchronized IPosterDB getiPosterDBDB()
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
}
