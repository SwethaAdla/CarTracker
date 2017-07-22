package com.swetha.service;

import com.swetha.entity.Reading;
import com.swetha.entity.Vehicle;
import com.swetha.exception.BadRequestException;
import com.swetha.exception.ResourceNotFoundException;
import com.swetha.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sweth on 6/28/2017.
 */

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Transactional
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional
    public Vehicle findOne(String vinNo) {
        Vehicle v = vehicleRepository.findOne(vinNo);
        if(v==null){
            throw new ResourceNotFoundException("Vehicle with vin "+vinNo+" doesn't exist.");
        }
        return v;
    }

    @Transactional
    public Vehicle create(Vehicle v) {
        Vehicle accept = vehicleRepository.findOne(v.getVin());
        if(accept !=null){
            return update(v.getVin(),v);
        }
        return vehicleRepository.create(v);
    }

    @Transactional
    public Vehicle update(String vinNo, Vehicle v) {
        return vehicleRepository.update(v);
    }

    public void delete(String vinNo) {

    }
}
