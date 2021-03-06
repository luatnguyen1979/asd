package asd.booking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import asd.booking.dao.RouteDAO;
import asd.booking.domain.trip.Route;

/**
 * Servlet implementation class SearchSchedule
 */
public class SearchSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String tripWay = request.getParameter("trip");
			String fromPort = request.getParameter("fromport");
			String toPort = request.getParameter("toport");
			String departDate = request.getParameter("departdate");
			String returnDate = request.getParameter("returndate");
			String travelerNumber = request.getParameter("travelernumber");
			int numberPassenger = 0;
			int sourcePortId = 0;
			int destinationPortId = 0;
			try {
				numberPassenger = Integer.parseInt(travelerNumber);
				sourcePortId = Integer.parseInt(fromPort);
				destinationPortId = Integer.parseInt(toPort);
			} catch (NumberFormatException nfe) {
				
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("numberpassenger", new Integer(numberPassenger));
			session.setAttribute("tripway", tripWay);
			List<Route> routeList = (List<Route>)request.getSession().getAttribute("routelist");
			if (routeList == null)
				routeList = RouteDAO.getRoute(sourcePortId, destinationPortId, departDate);

			if (routeList != null) {
				String json = new Gson().toJson(routeList);
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
			}

			else
				response.sendRedirect("error.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
