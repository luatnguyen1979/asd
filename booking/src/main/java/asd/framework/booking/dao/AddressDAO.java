/**
 * 
 */
package asd.framework.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import asd.framework.booking.domain.Address;

/**
 * @author luatnguyen
 *
 */
public class AddressDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement prestmt = null;

	public static int insert(Address addr) {
		int id = -1;
		// preparing some objects for connection
		String insertAddress = "INSERT INTO ADDRESS(STREET1, STREET2, CITY, ZIPCODE, STATE) VALUES (?,?,?,?,?)";

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();

			// Insert Address
			prestmt = currentCon.prepareStatement(insertAddress, Statement.RETURN_GENERATED_KEYS);
			prestmt.setString(1, addr.getStreet1());
			prestmt.setString(2, addr.getStreet2());
			prestmt.setString(3, addr.getCity());
			prestmt.setString(4, addr.getZipCode());
			prestmt.setString(5, addr.getState());
			// execute insert SQL stetement
			int affectedRows = prestmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating Address failed, no rows affected.");
			}

			try (ResultSet generatedKeys = prestmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Address failed, no ID obtained.");
				}
			}

			System.out.println("Record is inserted into Address table with id: " + id);

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

	public static int getAddressId(Address addr) {
		int id = -1;
		Statement stmt = null;

		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("select addressid from address where street1='" + addr.getStreet1() + "' and street2='"
				+ addr.getStreet2() + "' and city='" + addr.getCity() + "' and zipcode='" + addr.getZipCode()
				+ "' and state='" + addr.getState() + "'");

		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery.toString());
			boolean more = rs.next();

			if (more) {
				id = rs.getInt("addressid");
				System.out.println("Address Id " + id);

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

		return id;
	}

	public static Address get(int id){
	    Address ret = null;
        final String sql = "SELECT * FROM address WHERE addressid = ?";
        try {
            currentCon = ConnectionManager.getConnection();
            prestmt = currentCon.prepareStatement(sql);
            prestmt.setInt(1, id);
            rs = prestmt.executeQuery();
            if (rs.next()) {
                String street1 = rs.getString("street1");
                String street2 = rs.getString("street2");
                String city = rs.getString("city") ;
                String zipCode = rs.getString("zipcode");
                String state = rs.getString("state");
                ret = new Address(street1, street2, city, zipCode, state);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return ret;
	}
}
