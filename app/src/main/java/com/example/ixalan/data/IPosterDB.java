package com.example.ixalan.data;

public interface IPosterDB
{
    public int insertPoster(String url, int movieID);
    public String getPoster(int movieID);
}
