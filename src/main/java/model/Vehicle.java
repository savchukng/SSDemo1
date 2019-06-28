package model;

import annotation.COLUMN;
import annotation.Id;
import annotation.TABLE;

@TABLE("vehicles")
public class Vehicle {
    @Id
    @COLUMN("id")
    int id;
    @COLUMN("make")
    String make;
    @COLUMN("model")
    String model;
    @COLUMN("manufacture_year")
    int year;
    @COLUMN("driver_id")
    int driverId;
    @COLUMN("state")
    int state;
    @COLUMN("number_plate")
    String numberPlate;

    public Vehicle() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return make + " " + model + " " + year + ", State: " +
                state + " " + numberPlate + ", ID:" + id;
    }
}
