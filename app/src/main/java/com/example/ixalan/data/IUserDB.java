package com.example.ixalan.data;

import com.example.ixalan.objects.User;

public  interface IUserDB{

    // Get a User from the database by there userID
    public User getUser(int userID);

    //removes a user completely from the dataBase
    // updating should not use this function
    public void removeUser(int userID);

    //Update a user's full name in the dataBase by userID
    public void updateUserName(int userID, String firstName, String lastName);

    //update a user's first name only in the database by userID
    public void updateUserFirstName(int userID, String firstName);

    //update a user's last name only in the database by userID
    public void updateUserLastName(int userID, String lastName);

    public void updateAccountBalance(int changeBalance);

}