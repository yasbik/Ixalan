package ixalan.movieapp.business;

import java.text.DecimalFormat;
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
    private String details = "";

    public AccessMerchandise(final IMerchandiseDB merchandiseDB)
    {
        movie = null;
        this.merchandiseDB = merchandiseDB;
        merchandise = merchandiseDB.getAllMerchandise();
    }

    public int getMerchandise_index()
    {
        return this.merchandise_index;
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

            details = "";

            if (toReturn != null) {
                details += ("Price: $" + new DecimalFormat("0.00").format(toReturn.getPrice()) + "\n\n");
                details += toReturn.getDescription();
            }
        }
        return toReturn;
    }

    public Merchandise getCurrentItem()
    {
        Merchandise toReturn = null;
        if (merchandise != null && !merchandise.isEmpty())
        {
            toReturn = merchandise.get(merchandise_index);

            details = "";

            if (toReturn != null) {
                details += ("Price: $" + new DecimalFormat("0.00").format(toReturn.getPrice()) + "\n\n");
                details += toReturn.getDescription();
            }
        }
        return toReturn;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public boolean setQuantity(int quantity)
    {
        boolean toReturn = false;
        if (quantity >= 0)
        {
            if (merchandise != null && !merchandise.isEmpty()) {
                Merchandise item = getCurrentItem();
                if (item != null && quantity <= item.getStock()) {
                    this.quantity = quantity;
                    toReturn = true;
                }
            }
        }
        return toReturn;
    }

    public String getDetails()
    {
        return this.details;
    }

    public void setMerchandise_index(int merchandise_index)
    {
        this.merchandise_index = merchandise_index;
    }

}
