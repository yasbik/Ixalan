package ixalan.movieapp.business;

import java.util.ArrayList;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public class AccessMerchandise
{
    private IMerchandiseDB merchandiseDB;
    private Movie movie;
    private ArrayList<Merchandise> merchandise;
    private int merchandise_index = 0;
    private int quantity = 0;

    public AccessMerchandise(final IMerchandiseDB merchandiseDB)
    {
        this();
        this.merchandiseDB = merchandiseDB;
        merchandise = merchandiseDB.getAllMerchandise();
    }

    public AccessMerchandise(final Movie movie)
    {
       this();
       this.movie = movie;
       merchandise = merchandiseDB.getMerchandiseForMovie(movie);
    }

    public AccessMerchandise()
    {
        merchandiseDB = Services.getiMerchandiseDB();
        merchandise = merchandiseDB.getAllMerchandise();
        movie = null;
    }

    public Movie getMovie()
    {
        return this.movie;
    }

    public Merchandise getNextItem()
    {
        Merchandise toReturn = null;
        if (merchandise != null && !merchandise.isEmpty())
        {
            toReturn = merchandise.get(merchandise_index);
            merchandise_index = (merchandise_index + 1) % merchandise.size();
            quantity = 0;
        }
        return toReturn;
    }

    public Merchandise getCurrentItem()
    {
        Merchandise toReturn = null;
        if (merchandise != null && !merchandise.isEmpty())
        {
            toReturn = merchandise.get(merchandise_index);
        }
        return toReturn;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        if (quantity >= 0)
        {
            if (merchandise != null && !merchandise.isEmpty()) {
                Merchandise item = merchandise.get(merchandise_index);
                if (item != null && quantity <= item.getStock()) {
                    this.quantity = quantity;
                }
            }
        }
    }

}
