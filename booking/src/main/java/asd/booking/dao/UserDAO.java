/**
 * 
 */
package asd.booking.dao;

/**
 * @author luatnguyen
 *
 */

import asd.booking.domain.User;

public interface UserDAO {
	public User login(User user);

	public void insert(User user, int custId);

}
