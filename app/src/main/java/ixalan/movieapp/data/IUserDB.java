package ixalan.movieapp.data;

import java.util.ArrayList;

import ixalan.movieapp.objects.User;

public  interface IUserDB{

    // Get a User from the database by there userID
    public User getUser(int userID);

    //removes a user completely from the dataBase
    // updating should not use this function
    public void removeUser(int userID);

    //update a user's first name only in the database by userID
    public void updateUserFirstName(int userID, String firstName);

    public void updateAccountBalance(int userID, int changeBalance);

    public void addUser(User newUser);

    public User getUSer(String name, String pass);

    public ArrayList<User> getAllUsers();
}