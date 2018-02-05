/**
 * 
 */
package asd.framework.booking.domain;

import java.io.Serializable;

/**
 * @author luatnguyen
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8241943357544065394L;
	private Integer userId;
	private String userName;
	private String password;
	private Integer customerId;

	public boolean valid;

	/**
	 * 
	 */
	public User() {
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * 
	 */
	public User(User user) {
		this.userName = user.userName;
		this.password = user.password;
		this.valid = user.valid;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the customerid
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
}
