package ixalan.movieapp.objects;

public class Admin extends User
{
    private String adminID; //possibly alphanumeric
    private String locationInCharge;

    public Admin(String name, String email, String password, int balance, int pointsBalance, int userID, String creditCard) {
        super(name, email, password, balance, pointsBalance, userID, creditCard);
    }

    public String getAdminID()
    {
        return this.adminID;
    }

    public String getLocationInCharge()
    {
        return this.locationInCharge;
    }

    public void setAdminID(String adminID)
    {
        this.adminID = adminID;
    }

    public void setLocationInCharge(String locationInCharge)
    {
        this.locationInCharge = locationInCharge;
    }
    
}

