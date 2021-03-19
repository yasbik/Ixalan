package ixalan.movieapp.objects;

import java.io.Serializable;

public class Theatre implements Serializable {
    private String name;
    private String location;
    private int screenOne;
    private int screenTwo;

    public Theatre()
    {
    }

    public Theatre(String name, String location, int screenOne, int screenTwo){
        this.name = name;
        this.location = location;
        this.screenOne = screenOne;
        this.screenTwo = screenTwo;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLocation()
    {
        return this.location;
    }

    public int getScreenOne(){ return this.screenOne;}

    public  int getScreenTwo(){ return this.screenTwo;}
    
}
