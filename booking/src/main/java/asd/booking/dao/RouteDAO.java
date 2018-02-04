package asd.booking.dao;

import java.util.List;

import asd.booking.domain.trip.Route;

public interface RouteDAO {

    //public Route getRoute(int sourcePortId, int destinationPortId, LocalDateTime departureDate);

    public List<Route> getRoute(int sourcePortId, int destinationPortId, String departureDate);

    public Route get(int id);
}
