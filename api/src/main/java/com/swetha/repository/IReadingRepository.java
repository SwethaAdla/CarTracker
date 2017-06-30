package com.swetha.repository;

import com.swetha.entity.Alert;
import com.swetha.entity.Reading;
import com.swetha.entity.Tire;

/**
 * Created by sweth on 6/29/2017.
 */
public interface IReadingRepository {
    Reading createReading(Reading r);
    Alert createAlert(Alert a);
    Tire createTire(Tire t);
}
