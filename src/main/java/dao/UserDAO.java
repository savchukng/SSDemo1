package dao;

import model.User;

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
