package model;

import annotation.COLUMN;
import annotation.Id;
import annotation.TABLE;
import dao.DAO;

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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Date getCompletionDate() {
        return completionDate;
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
            DAO prefDAO = new DAO(Preference.class);
            return (Preference) prefDAO.get(preferenceId);
        }
        return null;
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
}
