package dao;

import model.Route;
import util.HikariCPDataSource;

import java.sql.Connection;
import java.sql.Statement;

public class RouteDAO extends DAOImpl {

    public RouteDAO(){
        super(Route.class);
    }

    public void setCurrentLocation(int routeId, String location){
        String query = "UPDATE routes " +
                "SET current_location='" + location + "' WHERE id=" + routeId;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteRoute(int routeId){
        String query = "DELETE FROM routes WHERE id=" + routeId;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
