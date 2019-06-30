package dao;

import model.Application;
import model.Route;
import util.HikariCPDataSource;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationDAO extends DAOImpl {
    public ApplicationDAO(){
        super(Application.class);
    }
    public void newApplication(Application app){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(app.getRegistrationDate());
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            String query = "INSERT INTO applications(registration_date, user_id, origin, destination, additional_info, preference_id) VALUES(" +
                    "'" + date + "', " + app.getUserId() + ", '" + app.getOrigin() + "', '" + app.getDestination() + "', '" +
                    app.getAdditionalInfo() + "', " + app.getPreferenceId() +  ");";
            stmt.executeUpdate(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setReceptionDate(int id, Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            String query = "UPDATE applications SET reception_date='" + strDate + "' WHERE id=" + id;
            stmt.executeUpdate(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setCompletionDate(int id, Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            String query = "UPDATE applications SET completion_date='" + strDate + "' WHERE id=" + id;
            stmt.executeUpdate(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setDriverId(int appId, int driverId){
        String query = "UPDATE applications " +
                "SET driver_id=" + driverId + " WHERE id=" + appId;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteApp(int id){
        String query = "DELETE FROM applications WHERE id=" + id;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Route getDriverRoute(int driverId){
        Route route;
        List<Object> allApps =  getAll();
        for(Object appObj : allApps){
            Application app = (Application) appObj;
            if(app.getDriverId() == driverId){
                if((route = app.getRoute()) != null){
                    return route;
                }
            }
        }
        return null;
    }

    public List<Application> getClientApps(int id){
        List<Application> apps = new ArrayList<>();
        List<Object> allApps = getAll();
        if(allApps == null){
            return null;
        }
        for(Object objApp : allApps){
            Application app = (Application) objApp;
            if(app.getUserId() == id){
                apps.add(app);
            }
        }
        return apps;
    }
}
