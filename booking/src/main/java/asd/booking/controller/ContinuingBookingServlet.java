package asd.booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.framework.booking.dao.RouteDAO;
import asd.framework.booking.dao.TrainDAO;
import asd.framework.booking.dao.UserDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.Train;
import asd.framework.booking.domain.trip.Route;
import asd.framework.booking.logger.AbstractLogger;
import asd.framework.booking.logger.ChainBuilderLogger;
import asd.framework.booking.logger.LogLevel;

/**
 * Servlet implementation class ContinuingBookingServlet
 */
public class ContinuingBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AbstractLogger logger = ChainBuilderLogger.getLogger();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContinuingBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.logMessage(LogLevel.INFO, "Starting ConfirmCheckingOutServlet");
		String strId = request.getParameter("selection");
		int routeId = -1;
		try {
			routeId = Integer.parseInt(strId);
			HttpSession session = request.getSession(true);
			DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
			RouteDAO routeDAO = daoFactory.getRouteDAO();
			
			TrainDAO trainDAO = daoFactory.getTrainDAO();
			
			Route route = routeDAO.get(routeId);
			Train train = trainDAO.get(route.getTrain().getTrainId());
			route.setTrain(train);
			
			session.setAttribute("route", route);
			response.sendRedirect("passengerlist.jsp");

		} catch (NumberFormatException nfe) {
			logger.logMessage(LogLevel.DEBUG, nfe.getMessage());
			response.sendRedirect("error.jsp");
		}
		logger.logMessage(LogLevel.INFO, "Starting ConfirmCheckingOutServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
