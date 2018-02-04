package asd.booking.dao;

import asd.booking.domain.trip.Passenger;
import asd.booking.domain.trip.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TripDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement prestmt = null;
	
	public static int insert(Trip trip) {
		int id = -1;
		// preparing some objects for connection
		String insertAddress = "INSERT INTO trip (roundway, bookDate, route_id, customer_id) " + "VALUES (?,now(),?,?)";

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();

			// Insert Address
			prestmt = currentCon.prepareStatement(insertAddress, Statement.RETURN_GENERATED_KEYS);

			prestmt.setString(1, trip.getBookedDate());
			prestmt.setInt(2, trip.getRouteId());
			prestmt.setInt(3, trip.getCustomerId());

			// execute insert SQL stetement
			int affectedRows = prestmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating Trip failed, no rows affected.");
			}

			try (ResultSet generatedKeys = prestmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating Trip failed, no ID obtained.");
				}
			}

			System.out.println("Record is inserted into Trip table with id: " + id);
			

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

	public static Trip getTrip(int id) {

		Trip trip = new Trip();
		Statement stmt = null;

		String searchQuery = "SELECT * FROM trip WHERE id = " + id;
		// process

		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery.toString());
			while (rs.next()) {
				int tripId = rs.getInt("id");
				String tripWay = rs.getString("tripway");
				String bookingDate = rs.getString("bookDate");
				int routeId = rs.getInt("route_id");
				int customerId = rs.getInt("customer_id");
				String confirmationNumber = rs.getString("confirmationnumber");
				//Route route = RouteDAO.get(routeId);
				List<Passenger> passengerList = PassengerDAO.getList(tripId);
				//Customer cust = CustomerDAO.getCustomer(customerId);
				trip = new Trip(tripId, tripWay, passengerList, bookingDate, customerId, routeId, confirmationNumber);
				
			}

			System.out.println("Trip id: " + trip.getId());

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

		return trip;

	}

	public static List<Trip> getTripList(int customerId) {

		List<Trip> tripList = new ArrayList<Trip>();
		Statement stmt = null;

		String searchQuery = "SELECT * FROM trip WHERE customer_id = " + customerId;
		// process

		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery.toString());
			while (rs.next()) {
				int tripId = rs.getInt("id");
				String tripWay = rs.getString("tripway");
				String bookingDate = rs.getString("bookDate");
				int routeId = rs.getInt("route_id");
				String confirmationNumber = rs.getString("confirmationnumber");
				//Route route = RouteDAO.get(routeId);
				List<Passenger> passengerList = PassengerDAO.getList(tripId);
				//Customer cust = CustomerDAO.getCustomer(customerId);
				Trip trip = new Trip(tripId, tripWay, passengerList, bookingDate, customerId, routeId, confirmationNumber);
				tripList.add(trip);
			}

			System.out.println("Trip list size: " + tripList.size());

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

		return tripList;

	}
}
