package com.example.ixalan.objects;

import java.io.Serializable;

public class Theatre implements Serializable {
    private String name;
    private String location;

    public String getName()
    {
        return this.name;
    }

    public String getLocation()
    {
        return this.location;
    }
    
}
