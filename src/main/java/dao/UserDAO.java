package dao;

import model.User;
import util.HikariCPDataSource;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAOImpl {
    public UserDAO(){
        super(User.class);
    }
    public List<User> getAllDrivers(){
        List<User> drivers = new ArrayList<>();
        List<Object> allUsers = getAll();
        for(Object objUser : allUsers){
            User user = (User)objUser;
            if(user.getUserType().equals("driver")){
                drivers.add(user);
            }
        }
        return drivers;
    }

    public void setVehicleId(int driverId, int vehicleId){
        String query = "UPDATE vehicles " +
                "SET driver_id=" + driverId + " WHERE id=" + vehicleId;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setEmail(int userId, String email){
        String query = "UPDATE users " +
                "SET email='" + email + "' WHERE id=" + userId;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setPassword(int userId, String password){
        String query = "UPDATE users " +
                "SET password='" + password + "' WHERE id=" + userId;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<User> getAllClients(){
        List<User> clients = new ArrayList<>();
        List<Object> allUsers = getAll();
        for(Object objUser : allUsers){
            User user = (User)objUser;
            if(user.getUserType().equals("client")){
                clients.add(user);
            }
        }
        return clients;
    }
}
