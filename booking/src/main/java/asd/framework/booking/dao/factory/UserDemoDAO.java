package asd.framework.booking.dao.factory;

import java.util.List;

import asd.framework.booking.dao.factory.exeption.DAOException;
import asd.framework.booking.domain.UserDemo;

/**
 * This interface represents a contract for a DAO for the {@link UserDemo}
 * model. Note that all methods which returns the {@link UserDemo} from the DB,
 * will not fill the model with the password, due to security reasons.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */
public interface UserDemoDAO {

	// Actions
	// ------------------------------------------------------------------------------------

	/**
	 * Returns the user from the database matching the given ID, otherwise null.
	 * 
	 * @param id
	 *            The ID of the user to be returned.
	 * @return The user from the database matching the given ID, otherwise null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public UserDemo find(Long id) throws DAOException;

	/**
	 * Returns the user from the database matching the given email and password,
	 * otherwise null.
	 * 
	 * @param email
	 *            The email of the user to be returned.
	 * @param password
	 *            The password of the user to be returned.
	 * @return The user from the database matching the given email and password,
	 *         otherwise null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public UserDemo find(String email, String password) throws DAOException;

	/**
	 * Returns a list of all users from the database ordered by user ID. The list is
	 * never null and is empty when the database does not contain any user.
	 * 
	 * @return A list of all users from the database ordered by user ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<UserDemo> list() throws DAOException;

	/**
	 * Create the given user in the database. The user ID must be null, otherwise it
	 * will throw IllegalArgumentException. After creating, the DAO will set the
	 * obtained ID in the given user.
	 * 
	 * @param user
	 *            The user to be created in the database.
	 * @throws IllegalArgumentException
	 *             If the user ID is not null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void create(UserDemo user) throws IllegalArgumentException, DAOException;

	/**
	 * Update the given user in the database. The user ID must not be null,
	 * otherwise it will throw IllegalArgumentException. Note: the password will NOT
	 * be updated. Use changePassword() instead.
	 * 
	 * @param user
	 *            The user to be updated in the database.
	 * @throws IllegalArgumentException
	 *             If the user ID is null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void update(UserDemo user) throws IllegalArgumentException, DAOException;

	/**
	 * Delete the given user from the database. After deleting, the DAO will set the
	 * ID of the given user to null.
	 * 
	 * @param user
	 *            The user to be deleted from the database.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void delete(UserDemo user) throws DAOException;

	/**
	 * Returns true if the given email address exist in the database.
	 * 
	 * @param email
	 *            The email address which is to be checked in the database.
	 * @return True if the given email address exist in the database.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public boolean existEmail(String email) throws DAOException;

	/**
	 * Change the password of the given user. The user ID must not be null,
	 * otherwise it will throw IllegalArgumentException.
	 * 
	 * @param user
	 *            The user to change the password for.
	 * @throws IllegalArgumentException
	 *             If the user ID is null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void changePassword(UserDemo user) throws DAOException;

}