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
    String vMake;
    @COLUMN("v_model")
    String vModel;
    @COLUMN("v_year_from")
    int vYearFrom;
    @COLUMN("v_year_to")
    int vYearTo;
    @COLUMN("v_state_from")
    int vStateFrom;
    @COLUMN("v_state_to")
    int vStateTo;
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
        else
            this.vModel = "Any";
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
            this.vYearFrom = vYearTo;
        }
        else {
            this.vYearFrom = 2019;
        }
    }

    public int getvStateFrom() {
        return vStateFrom;
    }

    public void setvStateFrom(int vStateFrom) {
        if(vStateFrom != 0) {
            this.vStateFrom = 1;
        }
        else {
            this.vStateFrom = vStateFrom;
        }
    }

    public int getvStateTo() {
        return vStateTo;
    }

    public void setvStateTo(int vStateTo) {
        if(vStateTo != 0) {
            this.vStateFrom = 5;
        }
        else {
            this.vStateFrom = vStateTo;
        }
    }

    public String getvNumberPlate() {
        return vNumberPlate;
    }

    public void setvNumberPlate(String vNumberPlate) {
        this.vNumberPlate = vNumberPlate;
    }
}
