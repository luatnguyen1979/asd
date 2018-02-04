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
import asd.booking.domain.Report;
import asd.booking.domain.trip.Port;
import asd.booking.domain.trip.Route;

/**
 * @author luatnguyen
 *
 */
public class ReportDAOImpl implements ReportDAO {
	private DAOFactory daoFactory;
	//static final String SQL_FIND_BY_DATE = "SELECT * FROM report WHERE date >= ? and date < ?";
	static final String SQL_FIND_BY_DATE = "SELECT * FROM report";
	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it
	 * can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this User DAO for.
	 */
	public ReportDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public List<Report> getList(String startDate, String endDate) {
		List<Report> reports = new ArrayList<Report>();
		Object[] values = {  };
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_DATE, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Report report = new Report();
				;
				map(report, resultSet);
				reports.add(report);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return reports;
	}

	/**
	 * Map the current row of the given ResultSet to an Port.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an Port.
	 * @return The mapped Port from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private void map(Report report, ResultSet resultSet) throws SQLException {
		report.setDate(resultSet.getString("date"));
		report.setPassenger(resultSet.getInt("passenger"));
		report.setSourceName(resultSet.getString("sourceport"));
		report.setDestName(resultSet.getString("destport"));
		report.setTotalPrice(resultSet.getDouble("totalprice"));
		report.setTrainName(resultSet.getString("trainname"));

	}

}
