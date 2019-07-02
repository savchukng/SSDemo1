package service;

import com.google.gson.Gson;
import dao.*;
import model.Application;
import model.Preference;
import model.Route;
import model.Vehicle;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DispatcherService {

    private ApplicationDAO applicationDAO;
    private RouteDAO routeDAO;
    private UserDAO userDAO;

    public DispatcherService(){
        this.applicationDAO = new ApplicationDAO();
        this.routeDAO = new RouteDAO();
        this.userDAO = new UserDAO();
    }

    public void deleteApp(int appId){
        routeDAO.deleteAppRoute(appId);
        applicationDAO.deleteApp(appId);
    }

    public void setDriver(int appId, int driverId){
        applicationDAO.setDriverId(appId, driverId);
        applicationDAO.setReceptionDate(appId, new Date());
        Application app = (Application) applicationDAO.get(appId);
        Route route = new Route();
        route.setAppId(app.getId());
        route.setOrigin(app.getOrigin());
        route.setDestination(app.getDestination());
        route.setCurrentLocation("");
        routeDAO.save(route);
    }

    public void setVehicle(int driverId,int vehicleId){
        userDAO.setVehicleId(driverId, vehicleId);
    }
}
