/**
 * 
 */
package asd.framework.booking.dao.factory.impl;

import static asd.booking.dao.factory.utils.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import asd.framework.booking.dao.PortDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.dao.factory.exeption.DAOException;
import asd.framework.booking.domain.trip.Port;

/**
 * @author luatnguyen
 *
 */
public class PortDAOImpl implements PortDAO {
	private DAOFactory daoFactory;
	// private static final String SQL_INSERT = "INSERT INTO DemoUser (email,
	// password, firstname, lastname, birthdate) VALUES (?, MD5(?), ?)";
	private static final String SQL_FIND_ALL = "select * from port";
	private static final String SQL_FIND_BY_PORT_ID = "SELECT * FROM port WHERE id = ?";

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public PortDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Port> getPortList() {
		List<Port> ports = new ArrayList<Port>();
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Port port = new Port();
				map(port, resultSet);
				ports.add(port);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return ports;
	}

	@Override
	public Port get(int id) {
		Port port = new Port();
		Object[] values = { new Integer(id) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_PORT_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				map(port, resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return port;
	}

	/**
	 * Map the current row of the given ResultSet to an Port.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an Port.
	 * @return The mapped Port from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private void map(Port port, ResultSet resultSet) throws SQLException {
		port.setId(resultSet.getInt("id"));
		port.setName(resultSet.getString("name"));
		port.setAddressId(resultSet.getInt("address_id"));

	}

}
