package asd.booking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.booking.utils.Calculation;
import asd.framework.booking.discount.DiscountFacadeImpl;
import asd.framework.booking.discount.IDiscountFacade;
import asd.framework.booking.domain.trip.Passenger;
import asd.framework.booking.domain.trip.Route;
import asd.framework.booking.logger.AbstractLogger;
import asd.framework.booking.logger.ChainBuilderLogger;
import asd.framework.booking.logger.LogLevel;

/**
 * Servlet implementation class ConfirmCheckingOutServlet
 */
public class ConfirmCheckingOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AbstractLogger logger = ChainBuilderLogger.getLogger();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmCheckingOutServlet() {
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
		HttpSession session = request.getSession(true);
		List<Passenger> passengerList = new ArrayList<Passenger>();
		Route route = (Route) session.getAttribute("route");
		int numberPassenger = ((Integer) session.getAttribute("numberpassenger")).intValue();
		String promotionCode = request.getParameter("promotioncode");
		double discountrate = Calculation.getPromotionRatio(promotionCode);
		String tripWay = (String) session.getAttribute("tripway");
		// TODO use prototype here.
		for (int i = 0; i < numberPassenger; i++) {
			String fullNameParamName = "fullname" + (i + 1);
			String fullName = request.getParameter(fullNameParamName);
			String passengerTypeParamName = "passengertype" + (i + 1);
			String passengerType = request.getParameter(passengerTypeParamName);
			// double price = Calculation.getPrice(route, passengerType, promotionCode,
			// tripWay);
			IDiscountFacade discount = new DiscountFacadeImpl();
			double price = discount.getPrice(route, passengerType, tripWay);
			passengerList.add(new Passenger(null, fullName, passengerType, -1, price));
		}
		session.setAttribute("discountrate", new Double(discountrate));
		session.setAttribute("promotioncode", promotionCode);
		session.setAttribute("passengerlist", passengerList);
		response.sendRedirect("confirmation.jsp");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		logger.logMessage(LogLevel.INFO, "Ending ConfirmCheckingOutServlet");
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
