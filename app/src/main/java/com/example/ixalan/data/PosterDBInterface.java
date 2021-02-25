package com.example.ixalan.data;
import java.util.ArrayList;

public interface PosterDBInterface {

    public int insertPoster(int movieID, String url);
    public String getPoster(int movieID);
}