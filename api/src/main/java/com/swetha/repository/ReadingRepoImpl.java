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

/**
 * Created by sweth on 6/29/2017.
 */
@Repository
public class ReadingRepoImpl implements IReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //create reading in db
    public Reading createReading(Reading r) {
        Tire t =createTire(r.getTires());
        entityManager.persist(r);
        return r;
    }

    //create alert in db
    public Alert createAlert(Alert a) {
        entityManager.persist(a);
        return a;
    }

    public Tire createTire(Tire t) {
        entityManager.persist(t);
        return t;
    }
}
