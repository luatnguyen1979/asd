package asd.booking.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.booking.dao.PassengerDAO;
import asd.booking.dao.TripDAO;
import asd.booking.dao.UserDAO;
import asd.booking.dao.factory.DAOFactory;
import asd.booking.discount.DiscountFacadeImpl;
import asd.booking.discount.IDiscountFacade;
import asd.booking.domain.Customer;
import asd.booking.domain.User;
import asd.booking.domain.trip.Passenger;
import asd.booking.domain.trip.Route;
import asd.booking.domain.trip.Trip;
import asd.booking.utils.DateTimeUtils;
import asd.booking.utils.UniqueStringGenerator;

/**
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		Customer cust = (Customer) session.getAttribute("currentSessionCustomer");
		if (user == null || cust == null) {
			response.sendRedirect("userLogged.jsp");
		}
		String tripWay = (String) session.getAttribute("tripway");
		String promotionCode = (String) session.getAttribute("promotioncode");
		LocalDateTime bookTime = LocalDateTime.now();
		Route route = (Route) session.getAttribute("route");
		List<Passenger> passengerList = (ArrayList<Passenger>) session.getAttribute("passengerlist");
		String confirmationNumber = UniqueStringGenerator.generate(10);
		IDiscountFacade discount = new DiscountFacadeImpl();

		Trip trip = new Trip(null, tripWay, null, DateTimeUtils.adaptToDateTime(bookTime), cust.getCustomerId(),
				route.getId(), confirmationNumber);
		trip.setPassengerList(passengerList);
		double price = discount.getPrice(trip, route, promotionCode);
		trip.setTotalPrice(price);
		DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
		TripDAO tripDAO = daoFactory.getTripDAO();
		tripDAO.insert(trip);

		PassengerDAO passengerDAO = daoFactory.getPassengerDAO();
		for (Passenger passenger : passengerList) {
			passenger.setTripId(trip.getId());
			passengerDAO.insert(passenger);
		}
		session.setAttribute("confirmationnumber", confirmationNumber);

		// TODO send email with Confirmation Code
		// Remove all attribute after ordering successful

		session.removeAttribute("discountrate");
		session.removeAttribute("passengerlist");
		session.removeAttribute("reportList");
		session.removeAttribute("portList");
		session.removeAttribute("numberpassenger");
		session.removeAttribute("tripway");

		session.setAttribute("discountrate", null);
		session.setAttribute("passengerlist", null);
		session.setAttribute("reportList", null);
		session.setAttribute("portList", null);
		session.setAttribute("numberpassenger", null);
		session.setAttribute("tripway", null);

		response.sendRedirect("placeordersuccess.jsp");
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