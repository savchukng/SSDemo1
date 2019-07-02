package service;

import com.google.gson.Gson;
import dao.ApplicationDAO;
import dao.DAOImpl;
import dao.UserDAO;
import dao.VehicleDAO;
import model.Preference;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

public class AccountService {
    private UserDAO userDAO;
    private DAOImpl preferenceDAO;
    private VehicleDAO vehicleDAO;

    public AccountService(){
        this.userDAO = new UserDAO();
        this.preferenceDAO = new DAOImpl(Preference.class);
        this.vehicleDAO = new VehicleDAO();
    }

    public boolean checkPassword(HttpServletRequest request, String password){
        User user = (User) request.getSession().getAttribute("user");
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public String getErrorJSON(String msg){
        Map<String, String> options = new LinkedHashMap<>();
        options.put("error", msg);
        return new Gson().toJson(options);
    }

    public void registerUser(String username, String password, String email, String firstName, String lastName, String occupation){
        User newUser = new User(username, password, email, firstName, lastName, occupation);
        userDAO.save(newUser);
    }

    public void signOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
    }

    public boolean authorize(HttpServletRequest request){
        User user = (User) userDAO.get("username", request.getParameter("username"));
        if(user == null || !user.getPassword().equals(request.getParameter("password"))){
            return false;
        }
        else {
            request.getSession().setAttribute("user", user);
            return true;
        }
    }

    public void setEmail(User user, String email){
        userDAO.setEmail(user.getId(), email);
    }

    public void setPassword(User user, String password){
        userDAO.setPassword(user.getId(), password);
    }

}
