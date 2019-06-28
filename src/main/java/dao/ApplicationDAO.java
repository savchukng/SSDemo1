package dao;

import model.Application;
import model.Preference;

import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ApplicationDAO extends DAO {
    public ApplicationDAO(){
        super(Application.class);
    }
    public void newApplication(Application app){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(app.getRegistrationDate());
        try(Statement stmt = connection.createStatement()){
            String query = "INSERT INTO applications(registration_date, user_id, origin, destination, additional_info, preference_id) VALUES(" +
                    "'" + date + "', " + app.getUserId() + ", '" + app.getOrigin() + "', '" + app.getDestination() + "', '" +
                    app.getAdditionalInfo() + "', " + app.getPreferenceId() +  ");";
            System.out.println(query);
            stmt.executeUpdate(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
