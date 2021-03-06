package asd.booking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.booking.domain.trip.Passenger;
import asd.booking.domain.trip.Route;
import asd.booking.utils.Calculation;

/**
 * Servlet implementation class ConfirmCheckingOutServlet
 */
public class ConfirmCheckingOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmCheckingOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<Passenger> passengerList = new ArrayList<Passenger> ();
		Route route = (Route)session.getAttribute("route");
		int numberPassenger = ((Integer)session.getAttribute("numberpassenger")).intValue();
		String promotionCode = request.getParameter("promotioncode");
		double discountrate = Calculation.getPromotionRatio(promotionCode);
		String tripWay = (String)session.getAttribute("tripway");
		for (int i = 0; i < numberPassenger; i ++) {
			String fullName = request.getParameter("fullname" + i + 1);
			String passengerType = request.getParameter("passengertype" + i + 1);
			double price = Calculation.getPrice(route, passengerType, promotionCode, tripWay);
			passengerList.add(new Passenger(fullName, passengerType, price, -1));
		}
		session.setAttribute("discountrate", new Double(discountrate));
		session.setAttribute("passengerlist", passengerList);
		response.sendRedirect("confirmation.jsp");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
