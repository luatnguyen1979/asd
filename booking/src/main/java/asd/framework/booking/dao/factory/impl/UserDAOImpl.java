/**
 * 
 */
package asd.framework.booking.dao.factory.impl;

import static asd.booking.dao.factory.utils.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asd.framework.booking.dao.UserDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.dao.factory.exeption.DAOException;
import asd.framework.booking.domain.User;

/**
 * @author luatnguyen
 *
 */
public class UserDAOImpl implements UserDAO {
	private DAOFactory daoFactory;
	//private static final String SQL_INSERT = "INSERT INTO DemoUser (email, password, firstname, lastname, birthdate) VALUES (?, MD5(?), ?)";
	private static final String SQL_INSERT = "INSERT INTO User (email, password, firstname, lastname, birthdate) VALUES (?, ?, ?)";
	private static final String SQL_FIND_BY_USER_AND_PASSWORD = "SELECT userid, username, password, customerid FROM user WHERE username = ? AND password = ?";
	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public UserDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public User login(User user) {
		
		Object[] values = { user.getUserName(), user.getPassword() };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_USER_AND_PASSWORD, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				map(user, resultSet);
				user.setValid(true);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return user;
	}


	
	@Override
	public void insert(User user, int custId) throws IllegalArgumentException, DAOException {
		if (user.getUserId() != null) {
			throw new IllegalArgumentException("User is already created, the user ID is not null.");
		}

		Object[] values = { user.getUserName(), user.getPassword(), new Integer(custId) };
		
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setUserId(generatedKeys.getInt(1));
				} else {
					throw new DAOException("Creating user failed, no generated key obtained.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	// Constants
	// ----------------------------------------------------------------------------------


	// Helpers
	// ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to an User.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an User.
	 * @return The mapped User from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private void map(User user, ResultSet resultSet) throws SQLException {
		user.setUserId(resultSet.getInt("userid"));
		user.setUserName(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setCustomerId(resultSet.getInt("customerid"));

	}

}
