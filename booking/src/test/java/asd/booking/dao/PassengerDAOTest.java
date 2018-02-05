package asd.booking.dao;

import java.util.List;

import asd.booking.utils.PassengerType;
import asd.framework.booking.dao.PassengerDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.trip.Passenger;
import junit.framework.Assert;
import junit.framework.TestCase;

public class PassengerDAOTest extends TestCase {

	public void testInsert() {
		Passenger passenger = new Passenger(null, "Enkh Amgalan Erdenebat", PassengerType.ADULT, 1, 500.00);
		DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
		PassengerDAO passengerDAO = daoFactory.getPassengerDAO();
		passengerDAO.insert(passenger);
		Assert.assertTrue(passenger.getId() > 0);
	}

	public void testGetList() {
		DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
		PassengerDAO passengerDAO = daoFactory.getPassengerDAO();
		List<Passenger> result = passengerDAO.getList(1);
		Assert.assertNotNull(result);
	}

	public void testGetCount() {
		DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
		PassengerDAO passengerDAO = daoFactory.getPassengerDAO();
		Integer result = passengerDAO.getCount(1);
		Integer wrongValue = 0;
		Assert.assertNotSame(wrongValue, result);
	}
}