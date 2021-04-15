package ixalan.movieapp.objects;

import java.io.Serializable;

public abstract class User  {
    private String name;
    private String email;
    private String password;
    private int balance;
    private  int pointsBalance;
    private int userID;
    private String creditCard;

    public User(String name,String email, String password, int balance, int pointsBalance, int userID, String creditCard){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.pointsBalance = pointsBalance;
        this.userID =userID;
        this.creditCard = creditCard;
    }

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

    public int getPointsBalance(){ return this.pointsBalance;}

    public String getPassword(){return this.password;}

    public String getCreditCard(){return this.creditCard;}

    public void setName(String name) {this.name = name; }

    public void setUserID(int userID){this.userID= userID;}

    public  void setBalance(int balance){this.balance= balance;}

    public  void  setPointsBalance(int pointsBalance){ this.pointsBalance=pointsBalance;}
}
