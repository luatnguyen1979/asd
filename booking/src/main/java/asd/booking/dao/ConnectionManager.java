/**
 *
 */
package asd.booking.dao;

/**
 * @author luatnguyen
 */

import asd.booking.utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String PROPERTY_URL = "javabase.jdbc.url";
    private static final String PROPERTY_DRIVER = "javabase.jdbc.driver";
    private static final String PROPERTY_USERNAME = "javabase.jdbc.username";
    private static final String PROPERTY_PASSWORD = "javabase.jdbc.password";
    static Connection con;

    public static Connection getConnection() {

        try {

            String url = Config.getString(PROPERTY_URL);

            Class.forName(Config.getString(PROPERTY_DRIVER)).newInstance();

            try {
                con = DriverManager.getConnection(url, Config.getString(PROPERTY_USERNAME), Config.getString(PROPERTY_PASSWORD));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }
}
