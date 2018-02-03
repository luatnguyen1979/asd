package asd.booking.dao;

import asd.booking.domain.Customer;
import asd.booking.domain.trip.Passenger;
import asd.booking.domain.trip.Route;
import asd.booking.domain.trip.Trip;
import asd.booking.utils.PassengerType;
import asd.booking.utils.UniqueStringGenerator;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class TripDAOTest extends TestCase {

    public void testInsedrt() {
        Route route = new Route();
        route.setId(1);
        Customer customer = new Customer();
        customer.setUserId(1);
        Trip trip = new Trip();
        trip.setTotalPrice(100.0);
        trip.setBookedDate("2018-02-01");
        trip.setCustomerId(1);
        trip.setConfirmationNumber(UniqueStringGenerator.generate(10));
        trip.setRouteId(1);
        trip.setTripWay("1");
        List<Passenger> passengerList = new LinkedList<>();
        passengerList.add(new Passenger("Eegii", PassengerType.ADULT, 500.00, -1));
        trip.setPassengerList(passengerList);
        TripDAO.insert(trip);
        assertNotNull(trip.getId());
    }

    public void testGetTrip() {
        Trip result = TripDAO.getTrip(1);
        assertNotNull(result);
    }

    public void testGetTripList() {
        List<Trip> tripList = TripDAO.getTripList(1);
        assertNotNull(tripList);
    }
}