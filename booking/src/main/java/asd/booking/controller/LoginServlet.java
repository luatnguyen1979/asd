/**
 * 
 */
package asd.booking.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.framework.booking.dao.CustomerDAO;
import asd.framework.booking.dao.UserDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.dao.factory.UserDemoDAO;
import asd.framework.booking.domain.Customer;
import asd.framework.booking.domain.User;
import asd.framework.booking.logger.AbstractLogger;
import asd.framework.booking.logger.ChainBuilderLogger;
import asd.framework.booking.logger.LogLevel;

/**
 * @author luatnguyen
 *
 */

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private AbstractLogger logger = ChainBuilderLogger.getLogger();

	/**
	 * 
	 */
	private static final long serialVersionUID = 6645193318867169686L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		logger.logMessage(LogLevel.INFO, "Starting LoginServlet");
		try {

			User user = new User();
			user.setUserName(request.getParameter("un"));
			user.setPassword(request.getParameter("pw"));

			DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
			UserDAO userDAO = daoFactory.getUserDAO();
			userDAO.login(user);

			if (user.isValid()) {
				Customer cust = CustomerDAO.getCustomer(user.getUserId());
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				session.setAttribute("currentSessionCustomer", cust);
				session.setAttribute("isLogged", "true");
				response.sendRedirect("userlogged.jsp"); // logged-in page
			}

			else
				response.sendRedirect("invalidlogin.jsp"); // error page
		}

		catch (Throwable theException) {
			theException.printStackTrace();
			logger.logMessage(LogLevel.INFO, theException.getMessage());
		} finally {
			logger.logMessage(LogLevel.INFO, "Ending LoginServlet");
		}
	}
}
