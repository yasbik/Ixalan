package ixalan.movieapp.data;

import ixalan.movieapp.objects.Movie;
import ixalan.movieapp.objects.RegiUser;
import ixalan.movieapp.objects.Theatre;
import ixalan.movieapp.objects.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDB implements IUserDB{
    private final String dbPath;

    public  UserDB(final String dbPath){
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:"+ dbPath +"; shutdown =true", "SA","");
    }

    private User fromResultSet(final ResultSet rs) throws SQLException{
        User user = null;
        final int userID = rs.getInt("userID");
        final String userName = rs.getString("name");
        final int userBalance = rs.getInt("balance");
        final String userEmail = rs.getString("email");
        final String userPassword = rs.getString("password");
        final String userCC = rs.getString("creditcard");
        final int userPoints = rs.getInt("points");
        user = new RegiUser(userName, userEmail,userPassword,userBalance,userPoints,userID,userCC);

        return user;
    }

    @Override
    public void removeUser(int userID)
    {

    }
    
    @Override
    public User getUser(int userID) {
        User returnedUser= null;
        Integer uID = userID;

        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM users WHERE userID=?");
            st.setInt(1, uID);
            final ResultSet rs = st.executeQuery();
            returnedUser = fromResultSet(rs);

            rs.close();
            st.close();

            return  returnedUser;
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    public User getUSer(String name, String password){
        User returnedUser = null;

        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM users WHERE name=? AND password=?");
            st.setString(1, name);
            st.setString(2,password);
            final ResultSet rs = st.executeQuery();
            if(rs.next()) {
                returnedUser = fromResultSet(rs);
            }
            rs.close();
            st.close();

            return  returnedUser;
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }


    @Override
    public void addUser(User newUser){
        try(final Connection c= connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?,?,?)");
            Integer userID = newUser.getUserID();
            Integer balance = newUser.getBalance();
            st.setInt(1,userID);
            st.setString(2, newUser.getName());
            st.setString(3,newUser.getEmail());
            st.setString(4,balance.toString());

            st.executeUpdate();
        }catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }

    @Override
    public void updateUserFirstName(int userID, String firstName) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE users SET name = ? WHERE userID = ?");
            st.setInt(2, userID);
            st.setString(1, firstName);

            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    @Override
    public void updateAccountBalance(int userID, int changeBalance) {
        Integer uID;
        User user;
        try (final Connection c = connection()) {
            // Get the balance from DB
            final PreparedStatement sc = c.prepareStatement("SELECT balance FROM users WHERE userID = ?");
            uID = userID;
            sc.setInt(1,uID);
            final ResultSet rs = sc.executeQuery();
            user = fromResultSet(rs);

            //update the balance
            final PreparedStatement st = c.prepareStatement("UPDATE users SET balance = ? WHERE userID = ?");
            st.setInt(2, uID);
            st.setInt(1, (user.getBalance()+changeBalance));

            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public ArrayList<User> getAllUsers(){
        final ArrayList<User> users = new ArrayList<>();
        try(Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs= st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                final User user = fromResultSet(rs);
                users.add(user);
            }
            rs.close();
            st.close();

            return users;
        } catch(final SQLException e){
            throw new PersistenceException(e);
        }
    }
}
