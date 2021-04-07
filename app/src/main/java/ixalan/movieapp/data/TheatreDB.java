package ixalan.movieapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ixalan.movieapp.objects.Theatre;

public class TheatreDB implements ITheatreDB {
    private final String dbPath;

    public  TheatreDB(final String dbPath){
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:"+ dbPath +"; shutdown =true", "SA","");
    }

    private Theatre fromResultSet(final ResultSet rs) throws SQLException{
        Theatre theatre = null;
        final int theatreScreen1 = rs.getInt("screen1");
        final String theatreName = rs.getString("name");
        final String theatreLocation = rs.getString("location");
        final int theatreScreen2 = rs.getInt("screen2");
        theatre = new Theatre(theatreName, theatreLocation, theatreScreen1, theatreScreen2);
        return theatre;
    }

    @Override
    public ArrayList<Theatre> getAllTheatres() {
        final ArrayList<Theatre> theatres = new ArrayList<>();
        try(Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs= st.executeQuery("SELECT * FROM theatres");
            while(rs.next()){
                final Theatre theatre = fromResultSet(rs);
                theatres.add(theatre);
            }
            rs.close();
            st.close();

            return theatres;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Theatre> getTheatres(int movieID) {
        final ArrayList<Theatre> theatres = new ArrayList<>();
        try(Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs= st.executeQuery("SELECT * FROM theatres");
            while(rs.next()){
                Theatre theatre = fromResultSet(rs);
                if(theatre.getScreenOne() == movieID || theatre.getScreenTwo() == movieID){
                    theatres.add(theatre);
                }
            }
            rs.close();
            st.close();

            return theatres;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public void removeTheatre(String name) {
        try(final Connection c = connection()){
            final PreparedStatement sc = c.prepareStatement("DELETE FROM theatres WHERE name = ?");
            sc.setString(1,name);

            sc.executeUpdate();
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public void addTheatre(Theatre newTheatre) {
        try(final Connection c= connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO theatres VALUES(?,?,?,?)");
            Integer screenOne = newTheatre.getScreenOne();
            Integer screentwo = newTheatre.getScreenTwo();
            st.setString(1, newTheatre.getName());
            st.setString(2, newTheatre.getLocation());
            st.setString(3, screenOne.toString());
            st.setString(4, screentwo.toString());

            st.executeUpdate();
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
