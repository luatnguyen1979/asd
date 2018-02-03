package asd.booking.dao;

import asd.booking.domain.trip.Passenger;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

public class PassengerDAOTest extends TestCase {

    public void testInsert() {
        Passenger passenger = new Passenger(null,
                "Enkh Amgalan Erdenebat",
                PassengerType.ADULT,
                1);
        int i = PassengerDAO.insert(passenger);
        Assert.assertTrue(i > 0);
    }

    public void testGetList() {
        List<Passenger> result = PassengerDAO.getList(1);
        Assert.assertNotNull(result);
    }

    public void testGetCount() {
        Integer result = PassengerDAO.getCount(1);
        Integer wrongValue = 0;
        Assert.assertNotSame(wrongValue, result);
    }
}