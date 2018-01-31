package asd.booking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asd.booking.dao.CustomerDAO;
import asd.booking.domain.Address;
import asd.booking.domain.Customer;
import asd.booking.domain.Payment;
import asd.booking.domain.User;
import asd.booking.utils.Utils;

/**
 * @author luatnguyen
 *
 */

/**
 * Servlet implementation class RegisterCustomerServlet
 */
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCustomerServlet() {
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

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String telephone = request.getParameter("cellPhone");
			String email = request.getParameter("email");

			String street1 = request.getParameter("street1");
			String street2 = request.getParameter("street2");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipCode");
			String state = request.getParameter("state");
			Address address = new Address(street1, street2, city, zipcode, state);

			String cardType = request.getParameter("cardType");
			String holderName = request.getParameter("holderName");
			String cardNumber = request.getParameter("cardNumber");
			String expiredMonth = request.getParameter("expiredMonth");
			String expiredYear = request.getParameter("expiredYear");
			String ccv = request.getParameter("ccv");
			Payment payment = new Payment(Utils.getCardType(cardType), holderName, cardNumber, expiredMonth,
					expiredYear, ccv);

			boolean isSameBillingAddress = false;
			if (request.getParameter("isSameAddress") != null) {
				isSameBillingAddress = true;
			} else {

			}

			String payment_street1 = request.getParameter("payment_street1");
			String payment_street2 = request.getParameter("payment_street2");
			String payment_city = request.getParameter("payment_city");
			String payment_zipcode = request.getParameter("payment_zipCode");
			String payment_state = request.getParameter("payment_state");
			Address paymentAddress = new Address(payment_street1, payment_street2, payment_city, payment_zipcode,
					payment_state);

			User user = new User();
			user.setUserName(username);
			user.setPassword(password);

			payment.setBillingAddress(paymentAddress);
			Customer cust = new Customer(firstName, lastName, telephone, email, user);
			cust.setAddress(address);
			cust.setPayment(payment);
			System.out.println("Welcome " + firstName);

			int id = CustomerDAO.insert(cust, isSameBillingAddress);

			if (id > 0) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				session.setAttribute("currentSessionCustomer", cust);
				response.sendRedirect("userLogged.jsp"); // logged-in page
			}

			else
				response.sendRedirect("invalidLogin.jsp"); // error page
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
		doGet(request, response);
	}

}
