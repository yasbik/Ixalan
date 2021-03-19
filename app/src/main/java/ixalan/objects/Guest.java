package ixalan.objects;

public class Guest extends User
{
    private String guestID; //possibly alphanumeric

    public String getGuestID()
    {
        return this.guestID;
    }

    public void setGuestID(String guestID)
    {
        this.guestID = guestID;
    }
    
}
