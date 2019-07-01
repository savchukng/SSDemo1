package model;

import annotation.COLUMN;
import annotation.Id;
import annotation.TABLE;
import dao.ApplicationDAO;
import dao.DAOImpl;

@TABLE("users")
public class User {
    @Id
    @COLUMN("id")
    protected int id;
    @COLUMN("username")
    protected String username;
    @COLUMN("password")
    protected String password;
    @COLUMN("email")
    protected String email;
    @COLUMN("first_name")
    protected String firstName;
    @COLUMN("last_name")
    protected String lastName;
    @COLUMN("user_type")
    protected String occupation;

    public User(){}

    public User(String username, String password, String email, String firstName, String lastName, String occupation) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return occupation;
    }

    public void setUserType(String occupation) {
        this.occupation = occupation;
    }

    public Vehicle getDriversVehicle(){
        DAOImpl vehicleDAO = new DAOImpl(Vehicle.class);
        Vehicle vehicle = (Vehicle) vehicleDAO.get("driver_id", id);
        if(vehicle == null){
            return new Vehicle(){
                public String toString() {
                    return "-";
                }
            };
        }
        return vehicle;
    }

    public Route getDriversRoute(){
        ApplicationDAO applicationDAO = new ApplicationDAO();
        Route route = applicationDAO.getDriverRoute(id);
        return route;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + id + ")";
    }
}


