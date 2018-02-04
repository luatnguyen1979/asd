package asd.booking.dao;

import java.util.List;

import asd.booking.dao.factory.DAOFactory;
import asd.booking.domain.trip.Route;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RouteDAOTest extends TestCase {

	public void testGetRoute() {
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		RouteDAO routeDAO = javabase.getRouteDAO();
		List<Route> result = routeDAO.getRoute(1, 2, "2018-02-03");
		Assert.assertNotNull(result);
	}

	public void testGet() {
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		RouteDAO routeDAO = javabase.getRouteDAO();
		Route result = routeDAO.get(1);
		Assert.assertNotNull(result);
	}
}