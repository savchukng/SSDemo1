package service;

import com.google.gson.Gson;
import dao.ApplicationDAO;
import dao.DAOImpl;
import dao.RouteDAO;
import dao.VehicleDAO;
import model.Application;
import model.Preference;
import model.Route;
import model.Vehicle;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DriverService {
    private ApplicationDAO applicationDAO;
    private VehicleDAO vehicleDAO;
    private RouteDAO routeDAO;

    public DriverService(){
        this.applicationDAO = new ApplicationDAO();
        this.vehicleDAO = new VehicleDAO();
        this.routeDAO = new RouteDAO();
    }

    public void completeRoute(int routeId){
        Route route = (Route) routeDAO.get(routeId);
        applicationDAO.setCompletionDate(route.getAppId(), new Date());
        routeDAO.deleteRoute(route.getId());
    }

    public void setCurrentLocation(int routeId, String currentLocation){
        routeDAO.setCurrentLocation(routeId, currentLocation);
    }

    public void setState(int vehicleId, int state){
        vehicleDAO.setState(vehicleId, state);
    }
}
