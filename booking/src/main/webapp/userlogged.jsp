<%@include file="header.jsp"%>
<%@ page import="asd.framework.booking.domain.Customer"%>

<%

	Customer customer = (Customer) session.getAttribute("currentSessionCustomer");
%>

<h2>
	Welcome
	<%=customer.getFirstName() + " " + customer.getLastName()%></h2>
<form action="searchtrip" method=post border=0>
<table><tr><td><h4>Confirmation Number: </h4></td><td><input type="text" size=20 name=confirmedvalue></td><td><input type=submit name="search" value="Search"></td></tr></table>
</form>	
<a href="bookingsearchoption">Book Train</a>
&nbsp;&nbsp;
<a href="generatereport">Generate Report</a>
&nbsp;&nbsp;
<a href="logout">Log out</a>
<%@include file="footer.jsp"%>

