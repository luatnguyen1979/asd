package asd.booking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: Enkh A Erdenebat
 * Date: 2017-11-22
 * Time: 09:55
 */
public class Config {

    public static Properties properties;
    public static String filePath;

    static {
        loadConfig();
    }

    /**
     * Load properties file that located in the Tomcat base directory's conf folder.
     */
    public static void loadConfig() {
        try {
            File configDir = new File(System.getProperty("catalina.base"), "conf");
            File configFile = new File(configDir, "myconfig.properties");
            filePath = configFile.getAbsolutePath();
//            filePath = "/Users/luatnguyen/Desktop/ASD/bookingframework/booking/src/main/resources/conf/myconfig.properties";
            InputStream stream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key) {
        if (key == null || key.isEmpty()) return null;
        return properties.getProperty(key);
    }

    public static Long getLong(String key) {
        if (key == null || key.isEmpty()) return null;
        if (properties.getProperty(key) == null) {
            return null;
        } else {
            return Long.parseLong(properties.getProperty(key));
        }
    }

    public static Integer getInt(String key) {
        if (key == null || key.isEmpty()) return null;
        if (properties.getProperty(key) == null) {
            return null;
        } else {
            return Integer.parseInt(properties.getProperty(key));
        }
    }

    public static Double getDouble(String key) {
        if (key == null || key.isEmpty()) return null;
        if (properties.getProperty(key) == null) {
            return null;
        } else {
            return Double.parseDouble(properties.getProperty(key));
        }
    }

    public static Byte getByte(String key) {
        if (key == null || key.isEmpty()) return null;
        if (properties.getProperty(key) == null) {
            return null;
        } else {
            return Byte.parseByte(properties.getProperty(key));
        }
    }

    public static String getString(String key, String defaultValue) {
        if (getString(key) == null) {
            return defaultValue;
        } else {
            return getString(key);
        }
    }

    public static Double getDouble(String key, Double defaultValue) {
        if (getString(key) == null) {
            return defaultValue;
        } else {
            return getDouble(key);
        }
    }

    public static Byte getByte(String key, Byte defaultValue) {
        if (getString(key) == null) {
            return defaultValue;
        } else {
            return getByte(key);
        }
    }

    public static Integer getInt(String key, Integer defaultValue) {
        if (getString(key) == null) {
            return defaultValue;
        } else {
            return getInt(key);
        }
    }

    public static Long getLong(String key, Long defaultValue) {
        if (getString(key) == null) {
            return defaultValue;
        } else {
            return getLong(key);
        }
    }
}