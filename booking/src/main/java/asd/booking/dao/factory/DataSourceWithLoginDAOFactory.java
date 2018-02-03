package asd.booking.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * The DataSource-with-Login based DAOFactory.
 * 
 * @author luatnguyen
 *
 */

class DataSourceWithLoginDAOFactory extends DAOFactory {
	private DataSource dataSource;
	private String username;
	private String password;

	DataSourceWithLoginDAOFactory(DataSource dataSource, String username, String password) {
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
	}

	@Override
	Connection getConnection() throws SQLException {
		return dataSource.getConnection(username, password);
	}
}
