package asd.booking.dao.factory;

import asd.booking.utils.PassengerType;
import asd.booking.utils.UniqueStringGenerator;
import asd.framework.booking.dao.TripDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.Customer;
import asd.framework.booking.domain.trip.Passenger;
import asd.framework.booking.domain.trip.Route;
import asd.framework.booking.domain.trip.Trip;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class TripDAOTest extends TestCase {

	public void testInsert() {
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
		trip.setTripWay("oneway");
		List<Passenger> passengerList = new LinkedList<>();
		passengerList.add(new Passenger(null, "Eegii", PassengerType.ADULT, -1, 500.00));
		trip.setPassengerList(passengerList);
		// Obtain DAOFactory.
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		System.out.println("DAOFactory successfully obtained: " + javabase);

		// Obtain UserDAO.
		TripDAO tripDAO = javabase.getTripDAO();
		System.out.println("UserDAO successfully obtained: " + tripDAO);

		tripDAO.insert(trip);
		assertNotNull(trip.getId());
	}

	public void testGetTrip() {
		// Obtain DAOFactory.
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		System.out.println("DAOFactory successfully obtained: " + javabase);

		// Obtain UserDAO.
		TripDAO tripDAO = javabase.getTripDAO();
		System.out.println("UserDAO successfully obtained: " + tripDAO);

		Trip result = tripDAO.getTrip(1);
		assertNotNull(result);
	}

	public void testGetTripList() {
		// Obtain DAOFactory.
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		System.out.println("DAOFactory successfully obtained: " + javabase);

		// Obtain UserDAO.
		TripDAO tripDAO = javabase.getTripDAO();
		System.out.println("UserDAO successfully obtained: " + tripDAO);

		List<Trip> tripList = tripDAO.getTripList(1);
		assertNotNull(tripList);
	}
}