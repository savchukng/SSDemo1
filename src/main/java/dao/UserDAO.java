package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {
    public UserDAO(){
        super(User.class);
    }
    public List<User> getAllDrivers(){
        List<User> drivers = new ArrayList<>();
        List<Object> allUsers = getAll();
        int n = 0;
        for(Object objUser : allUsers){
            User user = (User)objUser;
            if(user.getUserType().equals("driver")){
                drivers.add(user);
            }
        }
        System.out.println(n);
        return drivers;
    }
}
