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
    private int index_ptr = 0;

    //Fields pertaining to the current merchandise item
    private int quantity = 0;
    private String details = "";
    private int stock = 0;

    public AccessMerchandise(final IMerchandiseDB merchandiseDB)
    {
        movie = null;
        this.merchandiseDB = merchandiseDB;
    }

    public AccessMerchandise(final Movie movie)
    {
        this();
        this.movie = movie;
    }

    public AccessMerchandise()
    {
        merchandiseDB = Services.getiMerchandiseDB();
        movie = null;
    }

    public int getIndexPointer()
    {
        return this.index_ptr;
    }

    public void incrementIndexPtr()
    {
        if (merchandise != null && !merchandise.isEmpty())
        {
            index_ptr = (index_ptr + 1) % merchandise.size();
            updateDetails();
        }
    }

    public Movie getMovie()
    {
        return this.movie;
    }

    public void setMovie(Movie movie)
    {
        if (movie != null)
        {
            this.movie = movie;
        }
    }

    public void getMerchandise()
    {
        if (movie != null && merchandiseDB != null)
        {
            ArrayList<Merchandise> updated_list = merchandiseDB.getMerchandiseForMovie(movie.getMovieID());

            if (updated_list != null)
            {
                merchandise = updated_list;
            }
        }
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public boolean setQuantity(int quantity)
    {
        boolean toReturn = false;
        if (quantity >= 0)
        {
            if (merchandise != null && !merchandise.isEmpty()) {
                Merchandise item = getCurrentItem();
                if (item != null && quantity <= stock) {
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

    public Merchandise getCurrentItem()
    {
        Merchandise toReturn = null;

        if (merchandise == null)
        {
            getMerchandise();
        }

        if (!merchandise.isEmpty() && index_ptr < merchandise.size())
        {
            toReturn = merchandise.get(index_ptr);

            if (toReturn != null)
            {
                updateDetails();
                stock = toReturn.getStock();
            }
        }
        return toReturn;
    }

    public boolean merchandiseAvailable()
    {
        return merchandise != null && !merchandise.isEmpty();
    }

    public void updateDetails()
    {
        if (!merchandise.isEmpty() && index_ptr < merchandise.size())
        {
            Merchandise item = merchandise.get(index_ptr);
            details = "";
            details += ("Price: $" + new DecimalFormat("0.00").format(item.getPrice()) + "\n\n");
            details += item.getDescription();
        }
    }
}
