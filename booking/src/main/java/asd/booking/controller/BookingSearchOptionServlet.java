package asd.booking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.framework.booking.dao.PortDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.trip.Port;

/**
 * Servlet implementation class DisplayOptionSearch
 */
public class BookingSearchOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingSearchOptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("test");
			DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
			PortDAO portDAO = daoFactory.getPortDAO();
			List<Port> portList = portDAO.getPortList();

			if (portList != null) {

				HttpSession session = request.getSession(true);
				session.setAttribute("portList", portList);
				response.sendRedirect("booking.jsp"); // logged-in page
			}

			else
				response.sendRedirect("error.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
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
