package ixalan.movieapp.business;
import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IUserDB;
import ixalan.movieapp.objects.RegiUser;
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

    public void createUser(String name , String email , String pass ,String CC){

        if(user!=null){
            userDB = Services.getiUserDB();
            int tempId = 10000+(int)(Math.random()*100);
            user = new RegiUser(name , email ,pass , 0,0,tempId,CC);
            userDB.addUser(user);
        }
    }


}