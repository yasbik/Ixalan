package ixalan.movieapp.objects;

import java.time.LocalDateTime;

public class Ticket extends CartItem
{
    private Movie movie;
    private Theatre theatre;
    private final String ticketIdentifier;
    private LocalDateTime dateTime;

    public Ticket(Movie movie, Theatre theatre, String ticketIdentifier, float price, LocalDateTime dateTime)
    {
        super("Ticket: "+movie.getMovieName(), price, 1);
        this.movie = movie;
        this.theatre = theatre;
        this.ticketIdentifier = ticketIdentifier;
        this.dateTime = dateTime;
    }
}
