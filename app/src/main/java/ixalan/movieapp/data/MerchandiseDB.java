package ixalan.movieapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public class MerchandiseDB implements IMerchandiseDB
{
    private final String dbPath;

    public MerchandiseDB(final String dbPath){
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException
    {
        return DriverManager.getConnection("jbdc:hsqldb:file:" +dbPath+ ";shutdown =true", "SA", "");
    }

    private Merchandise fromResultSet(final ResultSet rs) throws SQLException {
        Merchandise merchandise = null;

        //TODO: Implement this after HSQLDB issues are fixed

        return merchandise;
    }

    @Override
    public void addMerchandise(Merchandise merchandise)
    {
        //TODO: Implement this after HSQLDB issues are fixed
    }

    @Override
    public ArrayList<Merchandise> getMerchandiseForMovie(Movie movie)
    {
        final ArrayList<Merchandise> merchandise = new ArrayList<>();

        try(Connection c = connection()) {

            //TODO: Implement this after HSQLDB issues are fixed

            return merchandise;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Merchandise> getAllMerchandise()
    {
        final ArrayList<Merchandise> merchandise = new ArrayList<>();

        try(Connection c = connection()) {

            //TODO: Implement this after HSQLDB issues are fixed

            return merchandise;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

}
