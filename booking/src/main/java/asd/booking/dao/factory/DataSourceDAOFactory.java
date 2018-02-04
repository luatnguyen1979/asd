package asd.booking.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * The DataSource based DAOFactory without username and password.
 * 
 * @author luatnguyen
 *
 */
public class DataSourceDAOFactory extends DAOFactory {
	private DataSource dataSource;

	public DataSourceDAOFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}