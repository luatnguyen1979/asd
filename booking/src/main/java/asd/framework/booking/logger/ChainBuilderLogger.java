/**
 * 
 */
package asd.framework.booking.logger;

/**
 * @author luatnguyen
 *
 */
public class ChainBuilderLogger {
	
	private static AbstractLogger logger;
	
	public static AbstractLogger getLogger() {
		AbstractLogger consoleLog = new ConsoleLogger(LogLevel.INFO);
		AbstractLogger errorLog = new ErrorLogger(LogLevel.ERROR);
		AbstractLogger fileLog = new FileLogger(LogLevel.DEBUG);
		errorLog.nextLogger = fileLog;
		fileLog.nextLogger = consoleLog;
		logger = errorLog;
		return logger;
	}
}
