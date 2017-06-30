package com.swetha.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;

/**
 * Created by sweth on 6/28/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",
                query = "SELECT vhl FROM Vehicle vhl ORDER BY vhl.vin DESC"),
        @NamedQuery(name = "Vehicle.findOne",
                query = "SELECT vhl FROM Vehicle vhl WHERE vhl.vin=:paramVin")
})
public class Vehicle {

    @Id
    private String vin;

    private String make;
    private String model;
    private int year;
    private double redlineRpm;
    private double maxFuelVolume;
    private Timestamp lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public double getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(double redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

}
