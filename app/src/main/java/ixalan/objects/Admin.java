package ixalan.objects;

public class Admin extends User
{
    private String adminID; //possibly alphanumeric
    private String locationInCharge;

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
