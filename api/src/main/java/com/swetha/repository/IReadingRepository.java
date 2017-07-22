package com.swetha.repository;

import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Tire;
import com.swetha.entity.Vehicle;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sweth on 6/29/2017.
 */
public interface IReadingRepository {
    Reading createReading(Reading r);
    Alert createAlert(Alert a);
    Tire createTire(Tire t);
    List<Alert> findAlerts(String vinNo);
    HashMap<String,Integer> noOfHighAlerts();
    List<Reading> findLocation(String vinNo);
    List<Reading> findAll();
    //List<Reading> getAllReadings(String vinNo);
}
