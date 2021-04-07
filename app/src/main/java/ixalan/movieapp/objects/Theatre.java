package ixalan.movieapp.objects;

import java.io.Serializable;

public class Theatre implements Serializable {
    private int id;
    private String name;
    private String location;
    private int screenOne;
    private int screenTwo;

    public Theatre()
    {
    }

    public void setID(int id)
    {
        this.id = id;
    }
    public int getID()
    {
        return this.id;
    }

    public Theatre(int id, String name, String location, int screenOne, int screenTwo){
        this.name = name;
        this.location = location;
        this.screenOne = screenOne;
        this.screenTwo = screenTwo;
        this.id = id;
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

    public boolean equals(Theatre theatre)
    {
        return theatre != null && this.id == theatre.getID();
    }
    
}
