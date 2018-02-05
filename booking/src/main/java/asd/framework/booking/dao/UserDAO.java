/**
 * 
 */
package asd.framework.booking.dao;

import asd.framework.booking.domain.User;

public interface UserDAO {
	public User login(User user);

	public void insert(User user, int custId);

}
