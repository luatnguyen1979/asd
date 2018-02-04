/**
 * 
 */
package asd.booking.dao;

import static asd.booking.dao.factory.utils.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import asd.booking.dao.factory.DAOFactory;
import asd.booking.dao.factory.exeption.DAOException;
import asd.booking.domain.UserDemo;
import asd.booking.domain.trip.Trip;
import asd.booking.utils.DateTimeUtils;

/**
 * @author luatnguyen
 *
 */
public class TripDAOImpl implements TripDAO {
	private DAOFactory daoFactory;
	//private static final String SQL_INSERT = "INSERT INTO DemoUser (email, password, firstname, lastname, birthdate) VALUES (?, MD5(?), ?)";
	private static final String SQL_INSERT = "INSERT INTO trip (tripway, bookDate, route_id, customer_id, confirmationnumber, totalprice) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_FIND_BY_TRIP_ID = "SELECT * FROM trip WHERE id = ?";
	private static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM trip WHERE customer_id = ?";
	private static final String SQL_FIND_BY_CONFIRMATION_NUMBER = "SELECT * FROM trip WHERE confirmationnumber = ?";
	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public TripDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	/* (non-Javadoc)
	 * @see asd.booking.dao.TripDAO#insert(asd.booking.domain.trip.Trip)
	 */
	@Override
	public void insert(Trip trip) {
		if (trip.getId() != null) {
			throw new IllegalArgumentException("Trip is already created, the Trip ID is not null.");
		}

		Object[] values = { trip.getTripWay(), trip.getBookedDate(), trip.getRouteId(), trip.getCustomerId(), trip.getConfirmationNumber(), trip.getTotalPrice() };
		
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Creating Trip failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					trip.setId(generatedKeys.getInt(1));
				} else {
					throw new DAOException("Creating Trip failed, no generated key obtained.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	

	/* (non-Javadoc)
	 * @see asd.booking.dao.TripDAO#getTrip(int)
	 */
	@Override
	public Trip getTrip(int id) {
		Trip trip = new Trip();
		Object[] values = { new Integer(id) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_TRIP_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				map(trip, resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return trip;
	}

	/* (non-Javadoc)
	 * @see asd.booking.dao.TripDAO#getTripList(int)
	 */
	@Override
	public List<Trip> getTripList(int customerId) {
		List<Trip> trips = new ArrayList<>();
		Object[] values = { new Integer(customerId) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_CUSTOMER_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Trip trip = new Trip();
				map(trip,resultSet);
				trips.add(trip);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return trips;
	}
	
	@Override
	public Trip getTrip(String confirmationNumber) {
		Trip trip = new Trip();
		Object[] values = { new Integer(confirmationNumber) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_CONFIRMATION_NUMBER, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				map(trip, resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return trip;
	}

	/**
	 * Map the current row of the given ResultSet to an Trip.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an Trip.
	 * @return The mapped User from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private void map(Trip trip, ResultSet resultSet) throws SQLException {
		trip.setId(resultSet.getInt("id"));
		trip.setTripWay(resultSet.getString("tripway"));
		trip.setBookedDate(DateTimeUtils.adaptToDateTime(resultSet.getTimestamp("bookdate").toLocalDateTime()));
		trip.setCustomerId(resultSet.getInt("customer_id"));
		trip.setRouteId(resultSet.getInt("route_id"));
		trip.setConfirmationNumber(resultSet.getString("confirmationnumber"));
		trip.setTotalPrice(resultSet.getDouble("totalprice"));

	}
}
