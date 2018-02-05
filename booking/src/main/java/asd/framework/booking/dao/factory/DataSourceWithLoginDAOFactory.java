package asd.framework.booking.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * The DataSource-with-Login based DAOFactory.
 * 
 * @author luatnguyen
 *
 */

public class DataSourceWithLoginDAOFactory extends DAOFactory {
	private DataSource dataSource;
	private String username;
	private String password;

	public DataSourceWithLoginDAOFactory(DataSource dataSource, String username, String password) {
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection(username, password);
	}

	/* (non-Javadoc)
	 * @see asd.booking.dao.factory.DAOFactory#free(java.sql.Connection)
	 */
	@Override
	public void free(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
	
}
