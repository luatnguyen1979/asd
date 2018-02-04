/**
 * 
 */
package asd.booking.dao;

import static asd.booking.dao.factory.utils.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asd.booking.dao.factory.DAOFactory;
import asd.booking.dao.factory.exeption.DAOException;
import asd.booking.domain.Train;

/**
 * @author luatnguyen
 *
 */
public class TrainDAOImpl implements TrainDAO {
	private DAOFactory daoFactory;
	
	private static final String SQL_FIND_BY_TRAIN_ID = "SELECT * FROM train WHERE trainid = ?";

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public TrainDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public Train get(int id) {
		Train train = new Train();
		Object[] values = { new Integer(id) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_TRAIN_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				map(train, resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return train;
	}
	
	/**
	 * Map the current row of the given ResultSet to an Train.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an
	 *            Train.
	 * @return The mapped Train from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private void map(Train train, ResultSet resultSet) throws SQLException {
		train.setTrainId(resultSet.getInt("trainid"));
		train.setModel(resultSet.getString("model"));
		train.setMadeBy(resultSet.getString("madeby"));
		train.setType(resultSet.getString("type"));
		train.setCapacity(resultSet.getInt("capacity"));

	}

}
