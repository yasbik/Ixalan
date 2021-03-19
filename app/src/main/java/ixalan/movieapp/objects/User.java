package ixalan.movieapp.objects;

public abstract class User {
    private String name;
    private String email;
    private int balance;
    private int userID;

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getBalance(){ return this.balance;}

    public int getUserID(){ return  this.userID;}

    public void setUserID(int userID){this.userID= userID;}
}
