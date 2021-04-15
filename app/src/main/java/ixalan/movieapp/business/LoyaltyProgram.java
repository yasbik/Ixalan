package ixalan.movieapp.business;

import ixalan.movieapp.application.Services;

public class LoyaltyProgram {

    public void payWithPoints(int ticketPrice, int userID) {

        int requiredPoints = ticketPrice * 10;

        int balance = Services.getiUserDB().getUser(userID).getBalance();

        Services.getiUserDB().updateAccountBalance(userID, balance - requiredPoints);

    }

    public boolean userHasBalance(int ticketPrice, int userID) {

        int requiredPoints = ticketPrice * 10;

        int balance = Services.getiUserDB().getUser(userID).getBalance();

        return (balance >= requiredPoints);
    }
}
