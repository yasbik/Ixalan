package ixalan.movieapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ixalan.movieapp.application.Services;
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
        return DriverManager.getConnection("jdbc:hsqldb:file:" +dbPath+ ";shutdown =true", "SA", "");
    }

    private Merchandise fromResultSet(final ResultSet rs) throws SQLException {
        Merchandise merchandise = null;
        final int merchId = rs.getInt("MERCHID");
        final String merchName = rs.getString("name");
        final float price = rs.getFloat("price");
        final int movieid = rs.getInt("movieid");
        final int stock = rs.getInt("stock");
        final String imageurl = rs.getString("imageurl");
        final String description = rs.getString("description");
        merchandise = new Merchandise(merchName, price);
        merchandise.setMovieTag(movieid);
        merchandise.setStock(stock);
        merchandise.setImageUrl(imageurl);
        merchandise.setDescription(description);
        merchandise.setMerchId(merchId);

        return merchandise;
    }

    @Override
    public void addMerchandise(Merchandise merchandise)
    {
        try(final Connection c= connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO merchandise VALUES(?,?,?,?,?,?,?)");

            st.setInt(1, merchandise.getMerchID());
            st.setString(2, merchandise.getName());
            st.setFloat(3, merchandise.getPrice());
            st.setInt(4,merchandise.getMovieTag());
            st.setInt(5, merchandise.getStock());
            st.setString(6, merchandise.getImageUrl());
            st.setString(7, merchandise.getDescription());

            st.executeUpdate();
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Merchandise> getMerchandiseForMovie(Movie movie)
    {
        final ArrayList<Merchandise> merchandise_list = new ArrayList<>();

        try(Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM merchandise where movieid = ?");
            st.setInt(1, movie.getMovieID());
            final ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                final Merchandise merchandise = fromResultSet(rs);
                merchandise_list.add(merchandise);
            }
            rs.close();
            st.close();
            return merchandise_list;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Merchandise> getAllMerchandise()
    {
        final ArrayList<Merchandise> merchandise = new ArrayList<>();

        try(Connection c = connection()) {

            final Statement st = c.createStatement();
            final ResultSet rs= st.executeQuery("SELECT * FROM merchandise");
            while(rs.next())
            {
                final Merchandise merchandise_item = fromResultSet(rs);
                merchandise.add(merchandise_item);
            }
            rs.close();
            st.close();

            return merchandise;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
