package asd.booking.discount;

import asd.booking.dao.PassengerDAO;
import asd.booking.dao.PassengerDAOImpl;
import asd.booking.dao.RouteDAO;
import asd.booking.dao.TripDAO;
import asd.booking.dao.factory.DAOFactory;
import asd.booking.domain.trip.Route;
import asd.booking.domain.trip.Trip;
import asd.booking.utils.PassengerType;
import asd.booking.utils.TripType;
import junit.framework.Assert;
import junit.framework.TestCase;

public class DiscountFacadeImplTest extends TestCase {

    public void testGetPrice() {
        DiscountFacadeImpl discountFacade = new DiscountFacadeImpl();
        DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		RouteDAO routeDAO = javabase.getRouteDAO();
        TripDAO tripDAO = javabase.getTripDAO();
        
        Route route = routeDAO.get(1);
        Trip trip = tripDAO.getTrip(1);
        PassengerDAO passengerDAO = new PassengerDAOImpl(DAOFactory.getInstance("javabase.jdbc"));
        trip.setPassengerList(passengerDAO.getList(1));
        System.out.println(discountFacade.getPrice(trip, route, "A"));
    }

    public void testGetPrice1() {
    	DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		RouteDAO routeDAO = javabase.getRouteDAO();
 
        Route route = routeDAO.get(1);
 
        DiscountFacadeImpl discountFacade = new DiscountFacadeImpl();
        Double expected = 31.0;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.ADULT, TripType.SINGLE.getName()));
        expected = 62.0;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.ADULT, TripType.ROUND.getName()));
        expected = 0.0;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.INFANT, TripType.SINGLE.getName()));
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.INFANT, TripType.ROUND.getName()));
        expected = 15.5;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.CHILD, TripType.SINGLE.getName()));
        expected = 31.0;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.CHILD, TripType.ROUND.getName()));
        expected = 26.35;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.SENIOR, TripType.SINGLE.getName()));
        expected = 52.7;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.SENIOR, TripType.ROUND.getName()));
        expected = 23.25;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.MILITARY, TripType.SINGLE.getName()));
        expected = 46.5;
        Assert.assertEquals(expected, discountFacade.getPrice(route, PassengerType.MILITARY, TripType.ROUND.getName()));
    }
}