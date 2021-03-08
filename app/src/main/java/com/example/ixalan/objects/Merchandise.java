package com.example.ixalan.objects;

public class Merchandise
{
    private String name;
    private String description;
    private Movie movieTag; //movie to which this merchandise item is associated
    private float price;
    private int stock;

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Movie getMovieTag()
    {
        return this.movieTag;
    }

    public float getPrice()
    {
        return this.price;
    }

    public int getStock()
    {
        return this.stock;
    }
}
