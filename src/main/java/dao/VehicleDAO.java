package dao;

import model.Vehicle;
import util.HikariCPDataSource;

import java.sql.Connection;
import java.sql.Statement;

public class VehicleDAO extends DAOImpl {
    public VehicleDAO(){
        super(Vehicle.class);
    }

    public void setState(int id, int state){
        String query = "UPDATE vehicles " +
                "SET state='" + state + "' WHERE id=" + id;
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement()){
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
