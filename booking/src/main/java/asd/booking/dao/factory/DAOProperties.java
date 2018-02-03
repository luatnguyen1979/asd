package asd.booking.dao.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import asd.booking.dao.factory.exeption.DAOConfigurationException;

/**
 * This class immediately loads the DAO properties file 'dao.properties' once in
 * memory and provides a constructor which takes the specific key which is to be
 * used as property key prefix of the DAO properties file. There is a property
 * getter which only returns the property prefixed with 'specificKey.' and
 * provides the option to indicate whether the property is mandatory or not.
 *
 * @author luatnguyen
 */
public class DAOProperties {

	// Constants
	// ----------------------------------------------------------------------------------

	private static final String PROPERTIES_FILE = "/Users/luatnguyen/Desktop/ASD/bookingframework/booking/src/main/resources/db/db.properties";

	private static final Properties PROPERTIES = new Properties();

	static {
		File textFile = new File(PROPERTIES_FILE);
		InputStream propertiesFile;
		try {
			propertiesFile = new FileInputStream(textFile);
		} catch (FileNotFoundException fnfe) {
			throw new DAOConfigurationException("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.",
					fnfe);
		} catch (Exception ex) {
			throw new DAOConfigurationException(ex.getMessage());
		}

		try {
			PROPERTIES.load(propertiesFile);
		} catch (IOException ioe) {
			throw new DAOConfigurationException("Cannot load properties file '" + PROPERTIES_FILE + "'.", ioe);
		} catch (Exception ex) {
			throw new DAOConfigurationException(ex.getMessage());
		}
	}

	// Vars
	// ---------------------------------------------------------------------------------------

	private String specificKey;

	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct a DAOProperties instance for the given specific key which is to be
	 * used as property key prefix of the DAO properties file.
	 * 
	 * @param specificKey
	 *            The specific key which is to be used as property key prefix.
	 * @throws DAOConfigurationException
	 *             During class initialization if the DAO properties file is missing
	 *             in the classpath or cannot be loaded.
	 */
	public DAOProperties(String specificKey) throws DAOConfigurationException {
		this.specificKey = specificKey;
	}

	// Actions
	// ------------------------------------------------------------------------------------

	/**
	 * Returns the DAOProperties instance specific property value associated with
	 * the given key with the option to indicate whether the property is mandatory
	 * or not.
	 * 
	 * @param key
	 *            The key to be associated with a DAOProperties instance specific
	 *            value.
	 * @param mandatory
	 *            Sets whether the returned property value should not be null nor
	 *            empty.
	 * @return The DAOProperties instance specific property value associated with
	 *         the given key.
	 * @throws DAOConfigurationException
	 *             If the returned property value is null or empty while it is
	 *             mandatory.
	 */
	public String getProperty(String key, boolean mandatory) throws DAOConfigurationException {
		String fullKey = specificKey + "." + key;
		String property = PROPERTIES.getProperty(fullKey);

		if (property == null || property.trim().length() == 0) {
			if (mandatory) {
				throw new DAOConfigurationException("Required property '" + fullKey + "'"
						+ " is missing in properties file '" + PROPERTIES_FILE + "'.");
			} else {
				// Make empty value null. Empty Strings are evil.
				property = null;
			}
		}

		return property;
	}

}