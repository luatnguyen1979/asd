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
import asd.booking.domain.trip.Passenger;

/**
 * @author luatnguyen
 *
 */
public class PassengerDAOImpl implements PassengerDAO {
	private DAOFactory daoFactory;

	private static final String SQL_INSERT = "INSERT INTO passenger (fullname, type, trip_id, price) VALUES (?, ?, ?, ?)";
	private static final String SQL_COUNT = "SELECT COUNT(*) AS numberpassenger FROM passenger WHERE trip_id = ?";
	private static final String SQL_FIND_BY_TRIP_ID = "SELECT * FROM passenger WHERE trip_id = ?";
	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public PassengerDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void insert(Passenger passenger) {
		if (passenger.getId() != null) {
			throw new IllegalArgumentException("Passenger is already created, the Trip ID is not null.");
		}

		Object[] values = { passenger.getFullname(), passenger.getPassengerType(), passenger.getTripId(),
				passenger.getPrice() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Creating Passenger failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					passenger.setId(generatedKeys.getInt(1));
				} else {
					throw new DAOException("Creating Passenger failed, no generated key obtained.");
				}
			}
			daoFactory.free(connection);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Passenger> getList(int tripId) {
		List<Passenger> passengers = new ArrayList<>();
		Object[] values = { new Integer(tripId) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_TRIP_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Passenger passenger = new Passenger();
				map(passenger, resultSet);
				passengers.add(passenger);
			}
			daoFactory.free(connection);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return passengers;
	}

	@Override
	public int getCount(int tripId) {
		int returnVal = 0;

		Object[] values = { new Integer(tripId) };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_COUNT, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				returnVal = resultSet.getInt(1);
			}
			daoFactory.free(connection);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return returnVal;

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
	private void map(Passenger passenger, ResultSet resultSet) throws SQLException {
		passenger.setId(resultSet.getInt("id"));
		passenger.setFullname(resultSet.getString("fullname"));
		passenger.setPassengerType(resultSet.getString("type"));
		passenger.setTripId(resultSet.getInt("trip_id"));
		passenger.setPrice(resultSet.getDouble("price"));

	}

}
