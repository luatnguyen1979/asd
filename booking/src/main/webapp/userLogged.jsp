<%@include file="header.jsp"%>
<%@ page import="asd.booking.domain.User,asd.booking.domain.Customer"%>

<%
	User currentUser = (User) session.getAttribute("currentSessionUser");
	Customer customer = (Customer) session.getAttribute("currentSessionCustomer");
%>

<h1>
	Welcome
	<%=customer.getFirstName() + " " + customer.getLastName()%>
</h1>
<a href="bookingsearchoption">Booking Train</a>
&nbsp;&nbsp;
<!-- <a href="searching.jsp">Search Train</a> -->
<!-- &nbsp;&nbsp; -->
<a href="logout">Log out</a>
<%@include file="footer.jsp"%>