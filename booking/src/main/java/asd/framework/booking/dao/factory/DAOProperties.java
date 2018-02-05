package asd.framework.booking.dao.factory;

import asd.booking.utils.Config;
import asd.framework.booking.dao.factory.exeption.DAOConfigurationException;

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

    // Vars
    // ---------------------------------------------------------------------------------------

    private String specificKey;

    // Constructors
    // -------------------------------------------------------------------------------

    /**
     * Construct a DAOProperties instance for the given specific key which is to be
     * used as property key prefix of the DAO properties file.
     *
     * @param specificKey The specific key which is to be used as property key prefix.
     * @throws DAOConfigurationException During class initialization if the DAO properties file is missing
     *                                   in the classpath or cannot be loaded.
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
     * @param key       The key to be associated with a DAOProperties instance specific
     *                  value.
     * @param mandatory Sets whether the returned property value should not be null nor
     *                  empty.
     * @return The DAOProperties instance specific property value associated with
     * the given key.
     * @throws DAOConfigurationException If the returned property value is null or empty while it is
     *                                   mandatory.
     */
    public String getProperty(String key, boolean mandatory) throws DAOConfigurationException {
        String fullKey = specificKey + "." + key;
        String property = Config.properties.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
            if (mandatory) {
                throw new DAOConfigurationException("Required property '" + fullKey + "'"
                        + " is missing in properties file '" + Config.filePath + "'.");
            } else {
                // Make empty value null. Empty Strings are evil.
                property = null;
            }
        }

        return property;
    }

}