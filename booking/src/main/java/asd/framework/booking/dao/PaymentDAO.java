/**
 * 
 */
package asd.framework.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import asd.framework.booking.domain.Payment;

/**
 * @author luatnguyen
 *
 */
public class PaymentDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement prestmt = null;

	public static int insert(Payment payment, int addressId) {
		int id = -1;
		// preparing some objects for connection

		String insertPayment = "INSERT INTO PAYMENT(CARDTYPE, HOLDERNAME, CARDNUMBER, EXPIREDMONTH, EXPIREDYEAR, CCV, ADDRESSID) VALUES (?,?,?,?,?,?,?)";

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			// Insert Address
			prestmt = currentCon.prepareStatement(insertPayment, Statement.RETURN_GENERATED_KEYS);
			prestmt.setString(1, payment.getCartType().toString());
			prestmt.setString(2, payment.getHolderName());
			prestmt.setString(3, payment.getCardNumber());
			prestmt.setString(4, payment.getExpiredMonth());
			prestmt.setString(5, payment.getExpiredYear());
			prestmt.setString(6, payment.getCcv());
			prestmt.setInt(7, addressId>0?addressId:null);
			// execute insert SQL stetement
			int affectedRows = prestmt.executeUpdate();

			if (affectedRows == 0) {
	            throw new SQLException("Creating Payment failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = prestmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                id = generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating Payment failed, no ID obtained.");
	            }
	        }
			
			System.out.println("Record is inserted into Payment table with id: " + id);

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

		return id;
	}
}
