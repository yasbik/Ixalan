package ixalan.movieapp.data;

import java.util.ArrayList;

import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public class FakeMerchandiseDB implements IMerchandiseDB {
    private ArrayList<Merchandise> Merchandise;

    public FakeMerchandiseDB() {
        Merchandise = new ArrayList<Merchandise>();
    }

    @Override
    public void addMerchandise(Merchandise merchandise) {
        if (merchandise != null) {
            this.Merchandise.add(merchandise);
        }
    }

    @Override
    public ArrayList<Merchandise> getMerchandiseForMovie(Movie movie)
    {
        final ArrayList <Merchandise> toReturn = new ArrayList<Merchandise>();
        for (Merchandise merchandise : this.Merchandise)
        {
            if (merchandise.getMovieTag().equals(movie))
            {
                toReturn.add(merchandise);
            }
        }
        return toReturn;
    }

    @Override
    public ArrayList<Merchandise> getAllMerchandise()
    {
        return this.Merchandise;
    }

}
