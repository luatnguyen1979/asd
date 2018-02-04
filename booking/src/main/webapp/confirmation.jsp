<%@include file="header.jsp"%>
<%@ page import="asd.booking.domain.trip.Route,asd.booking.domain.trip.Passenger,java.util.List, java.util.ArrayList"%>
<%

Route route = (Route) session.getAttribute("route");
List<Passenger> passengerList = (ArrayList<Passenger>) session.getAttribute("passengerlist");
Integer numberPassenger = (Integer) session.getAttribute("numberpassenger");
System.out.println(passengerList.size());
double totalPrice = 0;
double discountRate = ((Double) session.getAttribute("discountrate")).doubleValue();
%>


<h1>Ordering Tickets Confirmation</h1>
<form id="ticketlist" method="GET">
	<table width="1024px" border=1>
		<tr>
			<td colspan="6" class="section" align="center">Train Information:</td>

		</tr>
		
		<tr>
			<td width="15%">Train</td>
			<td width="25%">Departure Port</td>
			<td width="25%">Arrival Port</td>
			<td width="5%">Duration</td>
            <td width="15%">Departure Time</td>
            <td width="15%">Arrival Time</td>
		</tr>
		</table>
		
	<table width="1024px" border=1>	
	<tr>
            <td colspan="4" class="section" align="center">Passenger Information:</td>

        </tr>
        
        <tr>
            <td width="5%">No</td>
            <td width="45%">Passenger Name</td>
            <td width="30%">Passenger Type</td>
            <td width="20%">Price</td>

        </tr>
	
<%
int i = 0;
for (Passenger p: passengerList) {
	
%>
<tr>
            <td ><%=++i %></td>
            <td ><%= p.getFullname()%></td>
            <td ><%= p.getPassengerType()%></td>
            <td ><%=p.getPrice() %></td>

        </tr>
<% 
totalPrice += p.getPrice();
} 
%>
		<tr>
            <td colspan="4" align="right">Sum Price: <%=totalPrice %></td>
        </tr>
		<tr>
            <td colspan="4" align="right">Discounted: <%=totalPrice * discountRate%></td>
        </tr>
        <tr>
            <td colspan="4" align="right">Final Price: <%=totalPrice - (totalPrice * discountRate)%></td>
        </tr>
		<tr>
			<td colspan="4" align="right"><input id="submit" type="button" value="Place Order" /></td>
		</tr>
		
	</table>
	
</form>

<%@include file="footer.jsp"%>