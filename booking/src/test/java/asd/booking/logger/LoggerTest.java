/**
 * 
 */
package asd.booking.logger;

import asd.framework.booking.logger.AbstractLogger;
import asd.framework.booking.logger.ChainBuilderLogger;
import asd.framework.booking.logger.LogLevel;

/**
 * @author luatnguyen
 *
 */
public class LoggerTest {
	public static void main(String[] args) {
	      AbstractLogger logger = ChainBuilderLogger.getLogger();

	      logger.logMessage(LogLevel.INFO, 
	         "This is an information.");
System.out.println();
	      logger.logMessage(LogLevel.DEBUG, 
	         "This is an debug level information.");
	      System.out.println();
	      logger.logMessage(LogLevel.ERROR, 
	         "This is an error information.");
	   }
}
