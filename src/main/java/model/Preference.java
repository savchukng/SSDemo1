package model;

import annotation.COLUMN;
import annotation.Id;
import annotation.TABLE;

@TABLE("preferences")
public class Preference {
    @Id
    @COLUMN("id")
    int id;
    @COLUMN("v_make")
    String vMake = "Any make";
    @COLUMN("v_model")
    String vModel = "Any model";
    @COLUMN("v_year_from")
    int vYearFrom = 1980;
    @COLUMN("v_year_to")
    int vYearTo = 2019;
    @COLUMN("v_state_from")
    int vStateFrom = 1;
    @COLUMN("v_state_to")
    int vStateTo = 5;
    @COLUMN("v_number_plate")
    String vNumberPlate;

    public Preference() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getvMake() {
        return vMake;
    }

    public void setvMake(String vMake) {
        if(vMake != null) {
            this.vMake = vMake;
        }
        else
            this.vMake = "Any";
    }

    public String getvModel() {
        return vModel;
    }

    public void setvModel(String vModel) {
        if(vModel != null) {
            this.vModel = vModel;
        }
    }

    public int getvYearFrom() {
        return vYearFrom;
    }

    public void setvYearFrom(int vYearFrom) {
        if(vYearFrom != 0){
            this.vYearFrom = vYearFrom;
        }
        else {
            this.vYearFrom = 1970;
        }
    }

    public int getvYearTo() {
        return vYearTo;
    }

    public void setvYearTo(int vYearTo) {
        if(vYearFrom != 0){
            this.vYearTo  = vYearTo;
        }
        else {
            this.vYearTo = 2019;
        }
    }

    public int getvStateFrom() {
        return vStateFrom;
    }

    public void setvStateFrom(int vStateFrom) {
        if(vStateFrom != 0) {
            this.vStateFrom = vStateFrom;
        }
        else {
            this.vStateFrom = 1;
        }
    }

    public int getvStateTo() {
        return vStateTo;
    }

    public void setvStateTo(int vStateTo) {
        if(vStateTo != 0) {
            this.vStateTo = vStateTo;
        }
        else {
            this.vStateTo = 5;
        }
    }

    @Override
    public String toString() {
        return vMake + " " + vModel + " (" + vYearFrom + "-" + vYearTo + ") State: " + vStateFrom + "-" + vStateTo + " " + vNumberPlate;
    }

    public String getvNumberPlate() {
        return vNumberPlate;
    }

    public void setvNumberPlate(String vNumberPlate) {
        this.vNumberPlate = vNumberPlate;
    }
}
