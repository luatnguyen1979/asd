package asd.framework.booking.dao;

import java.util.List;

import asd.framework.booking.domain.trip.Passenger;

public interface PassengerDAO {


    public void insert(Passenger passenger);

    public List<Passenger> getList(int tripId);

    public int getCount(int tripId);
}
