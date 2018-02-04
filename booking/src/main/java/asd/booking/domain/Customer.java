/**
 * 
 */
package asd.booking.domain;

/**
 * @author luatnguyen
 *
 */
public class Customer extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2556059344018580596L;
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Address address;
	private String cellPhone;
	private String email;
	private Payment payment;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param cellPhone
	 * @param email
	 */
	public Customer(Integer customerId, String firstName, String lastName, String cellPhone, String email, User user) {
		super(user);
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellPhone = cellPhone;
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone
	 *            the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment
	 *            the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
