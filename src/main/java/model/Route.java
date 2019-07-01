package model;

import annotation.COLUMN;
import annotation.Id;
import annotation.TABLE;
import dao.ApplicationDAO;

@TABLE("routes")
public class Route {
    @Id
    @COLUMN("id")
    int id;
    @COLUMN("origin")
    String origin;
    @COLUMN("destination")
    String destination;
    @COLUMN("current_location")
    String currentLocation;
    @COLUMN("app_id")
    int appId;

    public Route() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getAppId() {
        return appId;
    }

    public Object getApp(){
        ApplicationDAO applicationDAO = new ApplicationDAO();
        return applicationDAO.get(appId);
    }

    @Override
    public String toString() {
        return origin + "->" + destination + " ID(" + id + ")";
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }
}
