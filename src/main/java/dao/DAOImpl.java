package dao;

import annotation.COLUMN;
import annotation.TABLE;
import annotation.Id;
import exception.DAOException;
import util.HikariCPDataSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class DAOImpl implements DAO {

    private Class clss;
    private String table;
    private List<Field> properties;
    private HashMap<Field, String> columns;

    public DAOImpl(Class clss){
        try {
            this.clss = clss;
            TABLE annotation = (TABLE) clss.getAnnotation(TABLE.class);
            table = annotation.value();
            Field[] allFields = clss.getDeclaredFields();
            properties = new ArrayList<>();
            columns = new HashMap<>();
            for (Field field : allFields) {
                if (field.isAnnotationPresent(COLUMN.class)) {
                    properties.add(field);
                    COLUMN column = field.getAnnotation(COLUMN.class);
                    columns.put(field, column.value());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Class getClss() {
        return clss;
    }

    public String getTable() {
        return table;
    }

    public List<Object> getAll(){
        List<Object> objects = new LinkedList<>();
        try(Connection connection = HikariCPDataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + ";")){
            while(rs.next()){
                Constructor constructor = clss.getDeclaredConstructor();
                Object newObject = constructor.newInstance();
                parseResult(newObject, rs);
                objects.add(newObject);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return objects;
    }

    public Object get(int id){
        Object newObject = null;
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE id = ?;")){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                throw new DAOException("No such record", null);
            }
            Constructor constructor = clss.getDeclaredConstructor();
            newObject = constructor.newInstance();
            parseResult(newObject, rs);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return newObject;
    }

    public Object get(String column, String value) {
        Object newObject = null;
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + column + " = ?;")){
            Constructor constructor = clss.getDeclaredConstructor();
            stmt.setString(1, value);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                throw new DAOException("No such record", null);
            }
            newObject = constructor.newInstance();
            parseResult(newObject, rs);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return newObject;
    }

    public Object get(String column, int value) {
        Object newObject = null;
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + column + " = ?;")){
            Constructor constructor = clss.getDeclaredConstructor();
            stmt.setInt(1, value);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                throw new DAOException("No such record " + value + " in column " + column + " in table " + table, null);
            }
            newObject = constructor.newInstance();
            parseResult(newObject, rs);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return newObject;
    }

    public void save(Object obj){
        String firstPartUpdate = "INSERT INTO " + table + "(";
        String secondPartUpdate = " VALUES(";
        try(Connection connection = HikariCPDataSource.getConnection()){
            for (Field field : properties) {
                if(!field.isAnnotationPresent(Id.class)) {
                    firstPartUpdate += columns.get(field) + ", ";
                    field.setAccessible(true);
                    Class type = field.getType();
                    if (type == int.class) {
                        secondPartUpdate += field.getInt(obj) + ", ";
                    } else if (type == String.class) {
                        secondPartUpdate += " '" + field.get(obj) + "', ";
                    } else if (type == float.class) {
                        secondPartUpdate += field.getFloat(obj) + ", ";
                    }
                    field.setAccessible(false);
                }
            }
            firstPartUpdate = firstPartUpdate.substring(0, firstPartUpdate.length() - 2) + ") ";
            secondPartUpdate = secondPartUpdate.substring(0, secondPartUpdate.length() - 2) + ");";
            PreparedStatement stmt = connection.prepareStatement(firstPartUpdate + secondPartUpdate, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate(firstPartUpdate + secondPartUpdate, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            for(Field field : properties){
                if(field.isAnnotationPresent(Id.class)){
                    field.setAccessible(true);
                    field.setInt(obj, rs.getInt(1));
                    field.setAccessible(false);
                }
            }
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void parseResult(Object object, ResultSet rs){
        try {
            for (Field field : properties) {
                field.setAccessible(true);
                Class type = field.getType();
                if (type == int.class) {
                    field.setInt(object, rs.getInt(columns.get(field)));
                } else if (type == String.class) {
                    field.set(object, rs.getString(columns.get(field)));
                } else if (type == float.class) {
                    field.set(object, rs.getFloat(columns.get(field)));
                } else if (type == Date.class) {
                    String dbDate = rs.getString(columns.get(field));
                    if(dbDate != null) {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        field.set(object, formatter.parse(dbDate));
                    }
                }
                field.setAccessible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
