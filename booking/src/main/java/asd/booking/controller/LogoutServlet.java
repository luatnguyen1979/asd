package asd.booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.framework.booking.logger.AbstractLogger;
import asd.framework.booking.logger.ChainBuilderLogger;
import asd.framework.booking.logger.LogLevel;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AbstractLogger logger = ChainBuilderLogger.getLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.logMessage(LogLevel.INFO, "Starting LogoutServlet");
		HttpSession session = request.getSession(true);

		session.setAttribute("discountrate", null);
		session.setAttribute("passengerlist", null);
		session.setAttribute("reportList", null);
		session.setAttribute("portList", null);
		session.setAttribute("numberpassenger", null);
		session.setAttribute("tripway", null);
		session.setAttribute("currentSessionUser", null);
		session.setAttribute("currentSessionCustomer", null);
		session.setAttribute("isLogged", null);

		response.sendRedirect("login.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		logger.logMessage(LogLevel.INFO, "Ending LogoutServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
