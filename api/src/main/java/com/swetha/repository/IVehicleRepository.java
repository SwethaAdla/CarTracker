package com.swetha.repository;

import com.swetha.entity.Reading;
import com.swetha.entity.Vehicle;

import java.util.List;

/**
 * Created by sweth on 6/28/2017.
 */
public interface IVehicleRepository {

    List<Vehicle> findAll();

    Vehicle findOne(String vinNo);

    Vehicle create(Vehicle v);

    Vehicle update(Vehicle v);

}
