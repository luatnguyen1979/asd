package asd.booking.dao;

import asd.framework.booking.dao.PortDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.trip.Port;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

public class PortDAOTest extends TestCase {

	public void testGetPortList() {
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		PortDAO portDAO = javabase.getPortDAO();
		List<Port> result = portDAO.getPortList();
		Assert.assertNotNull(result);
	}

	public void testGet() {
		DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
		PortDAO portDAO = javabase.getPortDAO();
		Port result = portDAO.get(1);
		Assert.assertNotNull(result);
	}
}