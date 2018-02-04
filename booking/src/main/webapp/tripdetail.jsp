<%@include file="header.jsp"%>
<%@ page import="asd.booking.domain.trip.Trip,asd.booking.domain.trip.Route,asd.booking.domain.trip.Passenger,java.util.List,java.util.ArrayList,java.time.LocalDateTime,asd.booking.utils.DateTimeUtils"%>
<%
Trip trip = (Trip) session.getAttribute("currenttrip");
Route route = null;
List<Passenger> passengerList = (ArrayList<Passenger>) session.getAttribute("passengerlist");
Integer numberPassenger = (Integer) session.getAttribute("numberpassenger");
System.out.println(passengerList.size());
double totalPrice = 0;
double discountRate = ((Double) session.getAttribute("discountrate")).doubleValue();
LocalDateTime departureTime = route.getDepartureDate();
LocalDateTime arrivalTime = route.getArrivalDate();
String startTime = DateTimeUtils.adaptToDateTime(departureTime);
String endTime = DateTimeUtils.adaptToDateTime(arrivalTime);
%>


<h2>Ordering Tickets Confirmation</h2>
<form id="ticketlist" action="placeorder" method="GET">
	<table width="1024px" border=1>
		<tr>
			<td colspan="6" class="section" align="center">Train Information:</td>

		</tr>
		
		<tr>
			<td width="15%" class="tdcenter">Train</td>
			<td width="20%" class="tdcenter">Departure Port</td>
			<td width="20%" class="tdcenter">Arrival Port</td>
			<td width="9%" class="tdcenter">Duration</td>
            <td width="18%" class="tdcenter">Departure Time</td>
            <td width="18%" class="tdcenter">Arrival Time</td>
		</tr>
		<tr>
            <td><%=route.getTrain().getName() %></td>
            <td><%=route.getSource().getName()%></td>
            <td><%=route.getDestination().getName() %></td>
            <td><%=route.getDuration() %></td>
            <td><b><%=startTime %></b></td>
            <td><b><%= endTime %></b></td>
        </tr>
		</table>
		
	<table width="1024px" border=1>	
	<tr>
            <td colspan="4" class="section" align="center">Passenger Information:</td>

        </tr>
        
        <tr>
            <td width="5%" class="tdcenter">No</td>
            <td width="45%" class="tdcenter">Passenger Name</td>
            <td width="30%" class="tdcenter">Passenger Type</td>
            <td width="20%" class="tdcenter">Price</td>

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
			<td colspan="4" align="right" class="bottomBorderLess"><br/><input id="submit" type="button" value="Home" onclick="window.location.href='userlogged.jsp'"/>&nbsp;&nbsp;<input id="submit" type="submit" value="Place Order" /></td>
		</tr>
		
	</table>
	
</form>

<%@include file="footer.jsp"%>