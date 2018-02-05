package asd.framework.booking.dao;

import java.util.List;

import asd.framework.booking.domain.trip.Trip;

public interface TripDAO {
	
	public void insert(Trip trip);

	public Trip getTrip(int id);
	
	public Trip getTrip(String confirmationNumber);

	public List<Trip> getTripList(int customerId);
}
