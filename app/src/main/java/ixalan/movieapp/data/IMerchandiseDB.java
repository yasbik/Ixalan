package ixalan.movieapp.data;

import java.util.ArrayList;

import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public interface IMerchandiseDB
{
    public void addMerchandise(Merchandise merchandise);

    public ArrayList<Merchandise> getMerchandiseForMovie(Movie movie);

    public ArrayList<Merchandise> getAllMerchandise();
}
