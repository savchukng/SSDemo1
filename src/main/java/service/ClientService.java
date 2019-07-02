package service;

import com.google.gson.Gson;
import dao.ApplicationDAO;
import dao.DAOImpl;
import dao.VehicleDAO;
import model.Application;
import model.Preference;
import model.User;
import model.Vehicle;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClientService {
    private ApplicationDAO applicationDAO;
    private DAOImpl preferenceDAO;
    private VehicleDAO vehicleDAO;

    public ClientService(){
        this.applicationDAO = new ApplicationDAO();
        this.preferenceDAO = new DAOImpl(Preference.class);
        this.vehicleDAO = new VehicleDAO();
    }

    public void requestRoute(int userId,String origin, String destination, String additionalInfo, String make, String model,
                                int yearFrom, int yearTo, int stateFrom, int stateTo, String numberPlate){
        Application app = new Application();
        Date date = new Date();
        app.setRegistrationDate(new Date());
        app.setUserId(userId);
        app.setOrigin(origin);
        app.setDestination(destination);
        app.setAdditionalInfo(additionalInfo);
        Preference preference = new Preference();
        preference.setvMake(make);
        preference.setvModel(model);
        preference.setvYearFrom(yearFrom);
        preference.setvYearTo(yearTo);
        preference.setvStateFrom(stateFrom);
        preference.setvStateTo(stateTo);
        preference.setvNumberPlate(numberPlate);
        preferenceDAO.save(preference);
        app.setPreferenceId(preference.getId());
        applicationDAO.newApplication(app);
    }

    public String getVehicleJSON(String numberPlate){
        Vehicle vehicle = (Vehicle) vehicleDAO.get("number_plate", numberPlate.toUpperCase());
        Map<String, String> options = new LinkedHashMap<>();
        options.put("make", vehicle.getMake());
        options.put("model", vehicle.getModel());
        options.put("year", String.valueOf(vehicle.getYear()));
        options.put("state", String.valueOf(vehicle.getState()));
        return new Gson().toJson(options);
    }
}
