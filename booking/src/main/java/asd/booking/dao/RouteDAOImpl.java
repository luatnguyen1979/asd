/**
 * 
 */
package asd.booking.dao;

import static asd.booking.dao.factory.utils.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import asd.booking.dao.factory.DAOFactory;
import asd.booking.dao.factory.exeption.DAOException;
import asd.booking.domain.Train;
import asd.booking.domain.trip.Route;

/**
 * @author luatnguyen
 *
 */
public class RouteDAOImpl implements RouteDAO {
	private DAOFactory daoFactory;

	private static final String SQL_FIND_ALL = "SELECT * FROM route r WHERE sourceport_id = ? AND destinationport_id = ? AND DATE(?) = ?";
	private static final String SQL_FIND_BY_ROUTE_ID = "SELECT * FROM route WHERE id = ?";

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public RouteDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Route> getRoute(int sourcePortId, int destinationPortId, String departureDate) {
		List<Route> routes = new ArrayList<Route>();
		Object[] values = { new Integer(sourcePortId), new Integer(destinationPortId), departureDate };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_ALL, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Route route = new Route();
				map(route, resultSet);
				routes.add(route);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return routes;
	}

	@Override
	public Route get(int id) {
		Route route = new Route();
		Object[] values = { new Integer(id) };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_ROUTE_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				map(route, resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return route;
	}

	/**
	 * Map the current row of the given ResultSet to an Route.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an
	 *            Route.
	 * @return The mapped Route from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private void map(Route route, ResultSet resultSet) throws SQLException {
		route.setId(resultSet.getInt("id"));
		route.setSourceId(resultSet.getInt("sourceport_id"));
		route.setDestinationId(resultSet.getInt("detinationport_id"));
		route.setDuration(resultSet.getDouble("duration"));
		route.setDistance(resultSet.getDouble("distance"));
		route.setPriceOneWay(resultSet.getDouble("pricesingleway"));
		route.setPriceRoundWay(resultSet.getDouble("priceroundway"));
		route.setDepartureDate(resultSet.getTimestamp("departuredate").toLocalDateTime());
		route.setArrivalDate(resultSet.getTimestamp("arrivaldate").toLocalDateTime());
		route.setTrain(new Train(resultSet.getInt("trainid")));

	}

}
