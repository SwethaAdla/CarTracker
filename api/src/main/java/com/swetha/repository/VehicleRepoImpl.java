package com.swetha.repository;

import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Tire;
import com.swetha.entity.Vehicle;
import com.swetha.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sweth on 6/28/2017.
 */
@Repository
public class VehicleRepoImpl implements IVehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    //find all the vehicles from db
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",Vehicle.class);
        return query.getResultList();
    }

    //find a perticular vehicle based on the vinNo
    public Vehicle findOne(String vinNo) {
        TypedQuery<Vehicle> query= entityManager.createNamedQuery("Vehicle.findOne",Vehicle.class);
        query.setParameter("paramVin",vinNo);
        if(query.getResultList().size()==0){
            return null;
        }
        return query.getResultList().get(0);
    }

    //create a new vehicle in db
    public Vehicle create(Vehicle v) {
        entityManager.persist(v);
        return v;
    }

    //update the vehicle if it is already existing in the db
    public Vehicle update(Vehicle v) {
        return entityManager.merge(v);
    }

}
