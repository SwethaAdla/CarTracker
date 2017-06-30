package com.swetha.controller;

import com.swetha.entity.Vehicle;
import com.swetha.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sweth on 6/28/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value= "/{vinNo}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vinNo") String vinNo){
        return vehicleService.findOne(vinNo);
    }

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method= RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> create(@RequestBody List<Vehicle> v){
        for(Vehicle v1 :v) {
           System.out.println(v1.getVin());
            vehicleService.create(v1);
        }
        return v;
    }

    @CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
    @RequestMapping(method= RequestMethod.PUT, value= "/{vinNo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vinNo") String vinNo, @RequestBody Vehicle v){
        return vehicleService.update(vinNo, v);
    }


}
