package asd.booking.dao;

import java.time.LocalDateTime;
import java.util.List;

import asd.booking.domain.trip.Route;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RouteDAOTest extends TestCase {

    public void testGetRoute() {
        List<Route> result = RouteDAO.getRoute(1, 2, "2018-02-03");
        Assert.assertNotNull(result);
    }

    public void testGetRoute1() {
        LocalDateTime localDate = LocalDateTime.of(2018, 2, 3, 0, 0, 0);
        Route result = RouteDAO.getRoute(1, 2, localDate);
        Assert.assertNotNull(result);

    }

    public void testGet() {
        Route result = RouteDAO.get(1);
        Assert.assertNotNull(result);
    }
}