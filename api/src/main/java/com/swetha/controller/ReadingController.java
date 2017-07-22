package com.swetha.controller;

import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Vehicle;
import com.swetha.service.IReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sweth on 6/29/2017.
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    IReadingService readingService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
        return readingService.findAll();
    }

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading r){
        readingService.createReading(r);
        return r;
    }

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value= "/{vinNo}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findVehicleAlerts(@PathVariable("vinNo") String vinNo){
        return readingService.findAlerts(vinNo);
    }

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value ="/alerts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HashMap<String,Integer> findHighAlerts(){
        return readingService.noOfHighAlerts();
    }

    /*@CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET,value= "/{vinNo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findLoc(@PathVariable("vinNo") String vinNo){
        return readingService.findLoc(vinNo);
    }*/
}
