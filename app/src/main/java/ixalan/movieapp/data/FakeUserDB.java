package ixalan.movieapp.data;
import java.util.ArrayList;

import ixalan.movieapp.data.IUserDB;
import ixalan.movieapp.objects.User;

public class FakeUserDB implements IUserDB
{
    private ArrayList<User> Users;

    public FakeUserDB()
    {
        Users = new ArrayList<User>();
    }

    @Override
    public User getUser(int userID)
    {
        return null;
    }

    @Override
    public void removeUser(int userID)
    {

    }

    @Override
    public void updateUserFirstName(int userID, String firstName)
    {

    }

    @Override
    public void updateAccountBalance(int userID, int changeBalance)
    {

    }

    @Override
    public void addUser(User newUser)
    {

    }

    @Override
    public ArrayList<User> getAllUsers()
    {
        return null;
    }
}
