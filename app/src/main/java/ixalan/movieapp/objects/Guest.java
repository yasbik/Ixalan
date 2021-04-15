package ixalan.movieapp.objects;

public class Guest extends User
{
    private String guestID; //possibly alphanumeric

    public Guest(String name, String email, String password, int balance, int pointsBalance, int userID, String creditCard) {
        super(name, email, password, balance, pointsBalance, userID, creditCard);
    }

    public String getGuestID()
    {
        return this.guestID;
    }

    public void setGuestID(String guestID)
    {
        this.guestID = guestID;
    }
    
}
