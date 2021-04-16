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

    public Ticket(Movie movie, float price)
    {
        super(movie.getMovieName(), price);
        this.ticketIdentifier = "";
    }

    public boolean equals(Ticket ticket)
    {
        return ticket.movie.equals(this.movie) && theatre.equals(ticket.getTheatre()) && dateTime.equals(ticket.getDateTime());
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getTicketIdentifier() {
        return ticketIdentifier;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
