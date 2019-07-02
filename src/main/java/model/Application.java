package model;

import annotation.COLUMN;
import annotation.Id;
import annotation.TABLE;
import dao.DAOImpl;
import dao.UserDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

@TABLE("applications")
public class Application {
    @Id
    @COLUMN("id")
    int id;
    @COLUMN("driver_id")
    int driverId;
    @COLUMN("registration_date")
    Date registrationDate;
    @COLUMN("reception_date")
    Date receptionDate;
    @COLUMN("completion_date")
    Date completionDate;
    @COLUMN("user_id")
    int userId;
    @COLUMN("origin")
    String origin;
    @COLUMN("destination")
    String destination;
    @COLUMN("dispatcher_id")
    int dispatcherId;
    @COLUMN("additional_info")
    String additionalInfo;
    @COLUMN("preference_id")
    int preferenceId;

    static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    public Application(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getRegistrationDate() {
        return formatter.format(registrationDate);
    }

    public Date getRegistrationDateObj(){
        return registrationDate;
    }

    public Date getReceptionDateObj(){
        return receptionDate;
    }

    public Date getCompletionDateObj(){
        return completionDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getReceptionDate() {
        if(receptionDate != null) {
            return formatter.format(receptionDate);
        }
        return null;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getCompletionDate() {
        if(completionDate != null) {
            return formatter.format(completionDate);
        }
        return null;
    }

    public Object getDriver() {
        DAOImpl userDAO = new DAOImpl(User.class);
        return userDAO.get(driverId);
    }

    public Object getUser() {
        DAOImpl userDAO = new DAOImpl(User.class);
        return userDAO.get(userId);
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public Preference getPreference(){
        if(preferenceId > 0) {
            DAOImpl prefDAO = new DAOImpl(Preference.class);
            return (Preference) prefDAO.get(preferenceId);
        }
        return null;
    }

    public Route getRoute(){
        DAOImpl routeDao = new DAOImpl(Route.class);
        return (Route) routeDao.get("app_id", id);
    }

    public String getStatus(){
        if(receptionDate == null){
            return "New";
        }
        else if(completionDate == null){
            return "In progress";
        }
        return "Completed";
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDispatcherId() {
        return dispatcherId;
    }

    public void setDispatcherId(int dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    @Override
    public String toString() {
        return origin + " -> " + destination + " (ID: " + id + ")";
    }
}
