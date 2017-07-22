package com.swetha.service;

import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Vehicle;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sweth on 6/29/2017.
 */
public interface IReadingService {

    Reading createReading(Reading r);
    List<Alert> findAlerts(String vinNo);
    HashMap<String,Integer> noOfHighAlerts();
    List<Reading> findLoc(String vinNo);
    List<Reading> findAll();
}
