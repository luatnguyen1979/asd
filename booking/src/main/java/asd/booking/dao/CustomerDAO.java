/**
 * 
 */
package asd.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import asd.booking.dao.factory.DAOFactory;
import asd.booking.domain.Address;
import asd.booking.domain.Customer;
import asd.booking.domain.Payment;
import asd.booking.domain.User;
import asd.booking.utils.Utils;

public class CustomerDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement prestmt = null;

	public static int insert(Customer cust, boolean isSameBillingAddress) {
		int custId = -1;
		int paymentId = -1;
		int paymentAddressId = -1;
		int addressId = -1;
		int userId = -1;
		// preparing some objects for connection

		String username = cust.getUserName();
		String password = cust.getPassword();
		String firstName = cust.getFirstName();
		String lastName = cust.getLastName();
		String cellPhone = cust.getCellPhone();
		String email = cust.getEmail();
		Address address = cust.getAddress();
		Payment payment = cust.getPayment();
		Address paymentAddress = payment.getBillingAddress();
		String insertCustomer = "INSERT INTO CUSTOMER(FIRSTNAME, LASTNAME, CELLPHONE, EMAIL, ADDRESSID, PAYMENTID) VALUES (?,?,?,?,?,?)";
//		String insertAddress = "INSERT INTO ADDRESS(STREET1, STREET2, CITY, ZIPCODE, STATE) VALUES (?,?,?,?,?)";
//		String insertPayment = "INSERT INTO PAYMENT(CARDTYPE, HOLDERNAME, CARDNUMBER, EXPIREDMONTH, EXPIREDYEAR, CCV, ADDRESSID) VALUES (?,?,?,?,?,?,?)";
//		String insertBillingAddress = "INSERT INTO ADDRESS(STREET1, STREET2, CITY, ZIPCODE, STATE) VALUES (?,?,?,?,?)";
		addressId = AddressDAO.insert(address);
		if (isSameBillingAddress) {
			paymentAddressId = addressId;
		} else {
			paymentAddressId = AddressDAO.insert(paymentAddress);
		}

		paymentId = PaymentDAO.insert(payment, paymentAddressId);
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			prestmt = currentCon.prepareStatement(insertCustomer, Statement.RETURN_GENERATED_KEYS);
			prestmt.setString(1, firstName);
			prestmt.setString(2, lastName);
			prestmt.setString(3, cellPhone);
			prestmt.setString(4, email);
			prestmt.setInt(5, addressId);
			prestmt.setInt(6, paymentId);
			

			// execute insert SQL stetement
			int affectedRows = prestmt.executeUpdate();
			if (affectedRows == 0) {
	            throw new SQLException("Creating Customer failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = prestmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                custId = generatedKeys.getInt(1);
	                cust.setCustomerId(custId);
	            }
	            else {
	                throw new SQLException("Creating Customer failed, no ID obtained.");
	            }
	        }
			System.out.println("Record is inserted into Customer table with id: " + custId);

			
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (prestmt != null) {
				try {
					prestmt.close();
				} catch (Exception e) {
				}
				prestmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
		UserDAO userDAO = daoFactory.getUserDAO();
		userDAO.insert(new User(username, password), custId);
		return custId;
	}
	
	/*
	
	private static Customer getCustomerBySQL(int userId) { 
		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("select *, aa.addressid as payment_street1, aa.street2 as payment_street2, aa.city as payment_city, aa.zipcode as payment_zipcode, aa.state as payment_state from user u");
		searchQuery.append(" left JOIN customer c ON u.customerid = c.customerid left join address a on c.addressid = a.addressid left join payment p on c.paymentid = p.paymentid left join address aa on p.addressid = aa.addressid");
		searchQuery.append(" where userid=" + userId);
		return getCustomerBySQL(searchQuery.toString());
	}
	
	private static Customer getCustomer(String promotionCode) { 
		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("select *, aa.addressid as payment_street1, aa.street2 as payment_street2, aa.city as payment_city, aa.zipcode as payment_zipcode, aa.state as payment_state from user u");
		searchQuery.append(" left JOIN customer c ON u.customerid = c.customerid left join address a on c.addressid = a.addressid left join payment p on c.paymentid = p.paymentid left join address aa on p.addressid = aa.addressid");
		searchQuery.append(" where promotionCode=" + promotionCode);
		return getCustomerBySQL(searchQuery.toString());
	}
	
	private static Customer getCustomerBySQL(String searchQuery) {
		Customer cust = new Customer();
		// preparing some objects for connection
		Statement stmt = null;

		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery.toString());
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("There is no customer information");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String telephone = rs.getString("cellphone");
				String email = rs.getString("email");
				
				String street1 = rs.getString("street1");
				String street2 = rs.getString("street2");
				String city = rs.getString("city");
				String zipcode = rs.getString("zipcode");
				String state = rs.getString("state");
				Address address = new Address(street1, street2, city, zipcode, state);
				
				String cardType = rs.getString("cardtype");
				String holderName = rs.getString("holdername");
				String cardNumber = rs.getString("cardnumber");
				String expiredMonth = rs.getString("expiredmonth");
				String expiredYear = rs.getString("expiredyear");
				String ccv = rs.getString("ccv");
				Payment payment = new Payment(Utils.getCardType(cardType), holderName, cardNumber, expiredMonth, expiredYear, ccv);
				
				String payment_street1 = rs.getString("payment_street1");
				String payment_street2 = rs.getString("payment_street2");
				String payment_city = rs.getString("payment_city");
				String payment_zipcode = rs.getString("payment_zipcode");
				String payment_state = rs.getString("payment_state");
				Address paymentAddress = new Address(payment_street1, payment_street2, payment_city, payment_zipcode, payment_state);
				
				payment.setBillingAddress(paymentAddress);
				cust = new Customer(firstName, lastName, telephone, email, new User(username, password));
				cust.setAddress(address);
				cust.setPayment(payment);
				System.out.println("Welcome " + firstName);
				
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return cust;
	}*/
	
	public static Customer getCustomer(int userId) {
		Customer cust = new Customer();
		// preparing some objects for connection
		Statement stmt = null;

		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("select *, aa.addressid as payment_street1, aa.street2 as payment_street2, aa.city as payment_city, aa.zipcode as payment_zipcode, aa.state as payment_state from user u");
		searchQuery.append(" left JOIN customer c ON u.customerid = c.customerid left join address a on c.addressid = a.addressid left join payment p on c.paymentid = p.paymentid left join address aa on p.addressid = aa.addressid");
		searchQuery.append(" where userid=" + userId);

		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery.toString());
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("There is no customer information");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				Integer customerId = rs.getInt("customerid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String telephone = rs.getString("cellphone");
				String email = rs.getString("email");
				
				String street1 = rs.getString("street1");
				String street2 = rs.getString("street2");
				String city = rs.getString("city");
				String zipcode = rs.getString("zipcode");
				String state = rs.getString("state");
				Address address = new Address(street1, street2, city, zipcode, state);
				
				String cardType = rs.getString("cardtype");
				String holderName = rs.getString("holdername");
				String cardNumber = rs.getString("cardnumber");
				String expiredMonth = rs.getString("expiredmonth");
				String expiredYear = rs.getString("expiredyear");
				String ccv = rs.getString("ccv");
				Payment payment = new Payment(Utils.getCardType(cardType), holderName, cardNumber, expiredMonth, expiredYear, ccv);
				
				String payment_street1 = rs.getString("payment_street1");
				String payment_street2 = rs.getString("payment_street2");
				String payment_city = rs.getString("payment_city");
				String payment_zipcode = rs.getString("payment_zipcode");
				String payment_state = rs.getString("payment_state");
				Address paymentAddress = new Address(payment_street1, payment_street2, payment_city, payment_zipcode, payment_state);
				
				payment.setBillingAddress(paymentAddress);
				cust = new Customer(customerId, firstName, lastName, telephone, email, new User(username, password));
				cust.setAddress(address);
				cust.setPayment(payment);
				System.out.println("Welcome " + firstName);
				
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return cust;
	}
}
