package asd.framework.booking.dao;

import java.util.List;

import asd.framework.booking.domain.trip.Port;

public interface PortDAO {
    

    public List<Port> getPortList();


    public Port get(int id);
}
