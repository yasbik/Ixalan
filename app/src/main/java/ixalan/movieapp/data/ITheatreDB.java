package ixalan.movieapp.data;

import java.util.ArrayList;

import ixalan.movieapp.objects.Theatre;

public interface ITheatreDB
{
    // get all theatres available
    public ArrayList<Theatre> getAllTheatres();

    // get all theatres that show a specific movie
    public ArrayList<Theatre> getTheatres(int movieID);

    public void removeTheatre(String name);

    public void addTheatre(Theatre newTheatre);

    public Theatre getTheatre(int theatreID);
}
