package ixalan.data;

import java.util.ArrayList;

import ixalan.objects.Theatre;

public interface ITheatreDB
{
    // get all theatres available
    public ArrayList<Theatre> getAllTheatres();

    // get all theatres that show a specific movie
    public ArrayList<Theatre> getTheatres(int movieID);

    public void removeTheatre(String name);

    public void addTheatre(Theatre newTheatre);
}
