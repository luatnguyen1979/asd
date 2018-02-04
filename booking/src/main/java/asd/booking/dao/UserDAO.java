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
//	static Connection currentCon = null;
//	static ResultSet rs = null;
//	static PreparedStatement prestmt = null;
//
//	public static User login(User user) {
//
//		// preparing some objects for connection
//		Statement stmt = null;
//
//		String username = user.getUserName();
//		String password = user.getPassword();
//
//		StringBuffer searchQuery = new StringBuffer();
//		searchQuery.append("select * from user where username='" + username + "' AND password='" + password + "'");
//		// process
//		System.out.println("Your user name is " + username);
//		System.out.println("Your password is " + password);
//		System.out.println("Query: " + searchQuery);
//
//		try {
//			// connect to DB
//			currentCon = ConnectionManager.getConnection();
//			stmt = currentCon.createStatement();
//			rs = stmt.executeQuery(searchQuery.toString());
//			boolean more = rs.next();
//
//			// if user does not exist set the isValid variable to false
//			if (!more) {
//				System.out.println("Sorry, you are not a registered user! Please sign up first");
//				user.setValid(false);
//			}
//
//			// if user exists set the isValid variable to true
//			else if (more) {
//				int userId = rs.getInt("userid");
//				user.setValid(true);
//				user.setUserId(userId);
//
//				System.out.println("Welcome " + user.getUserName());
//			}
//		}
//
//		catch (Exception ex) {
//			System.out.println("Log In failed: An Exception has occurred! " + ex);
//		}
//
//		// some exception handling
//		finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (Exception e) {
//				}
//				rs = null;
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (Exception e) {
//				}
//				stmt = null;
//			}
//
//			if (currentCon != null) {
//				try {
//					currentCon.close();
//				} catch (Exception e) {
//				}
//
//				currentCon = null;
//			}
//		}
//
//		return user;
//	}
//
//	public static int insert(User user, int custId) {
//		int id = -1;
//		// preparing some objects for connection
//
//		String username = user.getUserName();
//		String password = user.getPassword();
//
//		String insertUser = "INSERT INTO USER(USERNAME, PASSWORD, CUSTOMERID) VALUES (?,?,?)";
//
//		try {
//			// connect to DB
//			currentCon = ConnectionManager.getConnection();
//			prestmt = currentCon.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
//			prestmt.setString(1, username);
//			prestmt.setString(2, password);
//			prestmt.setInt(3, custId);
//
//			// execute insert SQL stetement
//			int affectedRows = prestmt.executeUpdate();
//			if (affectedRows == 0) {
//				throw new SQLException("Creating User failed, no rows affected.");
//			}
//
//			try (ResultSet generatedKeys = prestmt.getGeneratedKeys()) {
//				if (generatedKeys.next()) {
//					id = generatedKeys.getInt(1);
//				} else {
//					throw new SQLException("Creating User failed, no ID obtained.");
//				}
//			}
//			System.out.println("Record is inserted into USER table with id: " + id);
//		}
//
//		catch (Exception ex) {
//			System.out.println("Log In failed: An Exception has occurred! " + ex);
//		}
//
//		// some exception handling
//		finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (Exception e) {
//				}
//				rs = null;
//			}
//
//			if (prestmt != null) {
//				try {
//					prestmt.close();
//				} catch (Exception e) {
//				}
//				prestmt = null;
//			}
//
//			if (currentCon != null) {
//				try {
//					currentCon.close();
//				} catch (Exception e) {
//				}
//
//				currentCon = null;
//			}
//		}
//
//		return id;
//	}
	public User login(User user);
	public void insert(User user, int custId);

}
