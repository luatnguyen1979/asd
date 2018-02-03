package asd.booking.dao;

import java.util.List;

import asd.booking.domain.trip.Passenger;
import asd.booking.utils.PassengerType;
import junit.framework.Assert;
import junit.framework.TestCase;

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