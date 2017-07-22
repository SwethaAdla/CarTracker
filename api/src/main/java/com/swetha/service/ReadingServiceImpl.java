package com.swetha.service;

import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Tire;
import com.swetha.entity.Vehicle;
import com.swetha.exception.BadRequestException;
import com.swetha.exception.ResourceNotFoundException;
import com.swetha.repository.IReadingRepository;
import com.swetha.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sweth on 6/29/2017.
 */
@Service
public class ReadingServiceImpl implements IReadingService {

    @Autowired
    IReadingRepository readingRepository;
    @Autowired
    IVehicleRepository vehicleRepository;

    @Transactional
    public Reading createReading(Reading r) {
        //check if the vehicle exists in the vehicles table
        Vehicle v =  vehicleRepository.findOne(r.getVin());
        Tire t = r.getTires();
        Alert a = new Alert();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        if(v!=null){
            Reading rCreated = readingRepository.createReading(r);
            if(r.getEngineRpm()>v.getRedlineRpm()){
                //create high priority alert
                a.setVinNo(r.getVin());
                a.setAlertStatus("High");
                a.setMsg("Your EngineRPM exceeded RedLineRPM. Currently"+ r.getEngineRpm()+" Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(r.getFuelVolume()<(0.1 * v.getMaxFuelVolume())){
                //create medium priority alert
                a.setVinNo(r.getVin());
                a.setAlertStatus("Medium");
                a.setMsg("Your Fuel volume is low.Currently"+r.getFuelVolume()+" Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getFrontLeft()<32){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is less. Currently "+t.getFrontLeft()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getFrontRight()<32){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is less. Currently "+t.getFrontRight()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getRearLeft()<32){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is less. Currently "+t.getRearLeft()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getRearRight()<32){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is less. Currently "+t.getRearRight()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getFrontLeft()>36){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is more. Currently "+t.getFrontLeft()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getFrontRight()>36){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is more. Currently "+t.getFrontRight()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getRearLeft()>36){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is more. Currently "+t.getRearLeft()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(t.getRearRight()>36){
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Tire pressure is more. Currently "+t.getRearRight()+ " on Front left Please check.");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(r.isEngineCoolantLow()){
                //create a low priority alert
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Engine coolant is low. Please check");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            if(r.isCheckEngineLightOn()){
                //create a low priority alert
                a.setVinNo(r.getVin());
                a.setAlertStatus("Low");
                a.setMsg("Your Engine light is on. Please check");
                a.setTimeAlertGenerated(dateFormat.format(date));
                readingRepository.createAlert(a);
            }
            return  rCreated;
        }else{
            //if vahicle is not existing in the vehicle table throw exception
            throw new BadRequestException("The corresponding vehicle doesn't exist. Try again.");
        }
    }

    @Transactional
    public List<Alert> findAlerts(String vinNo) {
        List<Alert> alerts = readingRepository.findAlerts(vinNo);
        if(alerts==null){
            throw new ResourceNotFoundException("No Alerts found");
        }
        return alerts;
    }

    public HashMap<String,Integer> noOfHighAlerts() {
        HashMap<String,Integer> alertsMap = readingRepository.noOfHighAlerts();
        return alertsMap;
    }

    public List<Reading> findLoc(String vinNo) {
        List<Reading> readings = readingRepository.findLocation(vinNo);
        if(readings==null){
            throw new ResourceNotFoundException("No Location found");
        }
        return readings;
    }

    @Transactional
    public List<Reading> findAll() {
        return readingRepository.findAll();
    }
}
