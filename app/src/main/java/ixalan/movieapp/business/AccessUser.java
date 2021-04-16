package ixalan.movieapp.business;
import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IUserDB;
import ixalan.movieapp.objects.User;


public class AccessUser
{
    private IUserDB userDB;

    private User user;


    /*
    Constructor
    No arguments assumes empty search criteria and filter currently running movies
    */
    public AccessUser(String name, String pass)
    {
        userDB = Services.getiUserDB();
        user = userDB.getUSer(name, pass);
    }

    public User getUSer()
    {
        return user;
    }


}