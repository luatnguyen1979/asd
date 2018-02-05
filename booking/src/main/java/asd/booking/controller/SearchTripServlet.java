package asd.booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.framework.booking.dao.TripDAO;
import asd.framework.booking.dao.UserDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.trip.Trip;

/**
 * Servlet implementation class SearchTripServlet
 */
public class SearchTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchTripServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
		TripDAO tripDAO = daoFactory.getTripDAO();
		String confirmedNumber = request.getParameter("confirmedvalue");
		Trip trip = tripDAO.getTrip(confirmedNumber);// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		session.setAttribute("currenttrip", trip);

		response.sendRedirect("tripdetail.jsp");
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
