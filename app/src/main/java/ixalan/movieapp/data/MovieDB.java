package ixalan.movieapp.data;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.objects.Movie;

import java.sql.Connection;
//import org.hsqldb.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class MovieDB implements IMovieDB{
    private final String dbPath;

    public  MovieDB(final String dbPath){
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:hsqldb:file:" +dbPath+ ";shutdown =true", "SA", "");
    }

    private Movie fromResultSet(final ResultSet rs) throws SQLException{
        Movie movie = null;
        final String movieID = rs.getString("movieID");
        final String movieName = rs.getString("name");
        final String moviePoster = rs.getString("poster");
        final long movieDate = rs.getLong("date");
        final String movieSynopsis = rs.getString("synopsis");
        final String movieTrailer = rs.getString("trailer");
        final float movieRating = rs.getFloat("rating");
        final String castCrew = rs.getString("castcrew");
        final String theatreList = rs.getString("theatrelist");
        Date releasedate = new Date(movieDate);
        movie = new Movie(movieName, moviePoster,releasedate,movieSynopsis, movieTrailer);
        movie.setMovieID(Integer.parseInt(movieID));
        movie.setRating(movieRating);
        movie.setCastCrew(castCrew);

        movie.setTheatres(Services.getiTheatreDB().getTheatres(theatreList));
        return movie;
    }
    @Override
    public Movie getMovie(int movieID) {
        Movie returnedMovie= null;
        Integer mID = movieID;

        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM movies WHERE movieID=?");
            st.setString(1, mID.toString());
            final ResultSet rs = st.executeQuery();
            returnedMovie = fromResultSet(rs);

            rs.close();
            st.close();

            return  returnedMovie;
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public int removeMovie(int movieID) {
        Integer mID = movieID;

        try(final Connection c = connection()){
            final PreparedStatement sc = c.prepareStatement("DELETE FROM movies WHERE movieID = ?");
            sc.setString(1,mID.toString());
            sc.executeUpdate();
            return 0;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public void addMovie(Movie newMovie) {

        try(final Connection c= connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO movies VALUES(?,?,?)");
            Integer movieID = newMovie.getMovieID();
            st.setString(2,movieID.toString());
            st.setString(1, newMovie.getMovieName());
            st.setString(3,newMovie.getMoviePoster());

            st.executeUpdate();
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        final ArrayList<Movie> movies = new ArrayList<>();
        try(Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs= st.executeQuery("SELECT * FROM movies");
            while(rs.next()){
                final Movie movie = fromResultSet(rs);
                movies.add(movie);
            }
            rs.close();
            st.close();

            return movies;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
