<%@include file="header.jsp"%>
<%@ page import="asd.booking.domain.User,asd.booking.domain.Customer"%>

<%
	String confirmationNumber = (String)session.getAttribute("confirmationnumber");
%>

<h2>
	Order ticket was successful. An email was sent to you with the confirmed number is "<%=confirmationNumber %>"
	
</h2>
<a href="bookingsearchoption">Booking Train</a>
&nbsp;&nbsp;
<a href="userlogged.jsp">Home</a>
&nbsp;&nbsp;
<a href="logout">Log out</a>
<%@include file="footer.jsp"%>