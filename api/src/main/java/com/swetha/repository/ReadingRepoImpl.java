package com.swetha.repository;

import com.mysql.cj.core.conf.PropertyDefinitions;
import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Tire;
import com.swetha.entity.Vehicle;
import com.swetha.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    public List<Alert> findAlerts(String vinNo) {
        List<Alert> alerts = new ArrayList<Alert>();
        TypedQuery<Alert> query= entityManager.createNamedQuery("Alert.findOne",Alert.class);
        query.setParameter("paramVin",vinNo);
        if(query.getResultList().size()==0){
            return null;
        }else{
            for(int i=0;i<query.getResultList().size();i++){
                alerts.add(query.getResultList().get(i));
            }
        }
        return alerts;
    }

    public HashMap<String,Integer> noOfHighAlerts() {
        HashMap<String,Integer> alertsMap = new HashMap<String, Integer>();
        TypedQuery<Alert> query= entityManager.createNamedQuery("Alert.findRecentHighAlerts",Alert.class);
        Date date = new Date(System.currentTimeMillis() - (2 * 60 * 60 * 1000));
        query.setParameter("paramStatus","High");
        List<Alert> queryResult=query.getResultList();
        System.out.println("Result List"+queryResult);
        if(queryResult.size()==0){
            return null;
        }else{
            for(int i=0;i<queryResult.size();i++){
                Alert a = queryResult.get(i);
                System.out.println("Result List--------------------"+queryResult.get(i));
                //alertsMap.put(queryResult.get(i).getVinNo(),1);
                Date alertDate = new Date(a.getTimeAlertGenerated());
                if(alertDate.compareTo(date)>0){
                    if(!alertsMap.containsKey(a.getVinNo())){
                        alertsMap.put(a.getVinNo(),1);
                    }
                    else{
                        int k = alertsMap.get(a.getVinNo());
                        alertsMap.put(a.getVinNo(),k+1);
                    }
                }

            }

        }
        return alertsMap;
    }

    public List<Reading> findLocation(String vinNo) {
        List<Reading> readings = new ArrayList<Reading>();
        TypedQuery<Reading> query= entityManager.createNamedQuery("Reading.findLoc",Reading.class);
        query.setParameter("paramVin",vinNo);
        if(query.getResultList().size()==0){
            return null;
        }else{
            for(int i=0;i<query.getResultList().size();i++){
                readings.add(query.getResultList().get(i));
            }
        }
        return readings;
    }
    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll",Reading.class);
        return query.getResultList();
    }
}
