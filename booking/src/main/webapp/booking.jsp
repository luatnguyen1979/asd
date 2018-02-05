<%@include file="header.jsp"%>
<%@ page import="asd.framework.booking.domain.trip.Port,java.util.List, java.util.ArrayList,asd.framework.booking.domain.Customer"%>

<%
    List<Port> portList = (ArrayList<Port>) session.getAttribute("portList");
Customer customer = (Customer) session.getAttribute("currentSessionCustomer");
String isLogged = (String)session.getAttribute("isLogged");
%>


<h2>See Where the Train Can Take You</h2>
<%
if (isLogged!=null && isLogged.equals("true")) {
%>
<h4>
    User: 
    <%=customer.getFirstName() + " " + customer.getLastName()%></h4>
<a href="logout">Log out</a>

<%} else {
%>
<h4>
    User: Guest
    </h4>
<a href="login.jsp">Log in</a>

<%} %>

<form id="bookingSearch" method="GET">
	<table width="1024px" border=1>
		<tr>
			<td colspan="6" class="section" align="center">Book Tickets:</td>

		</tr>
		<tr>
			<td width="16%" class="tdcenter">Trip</td>
			<td width="20%" class="tdcenter">From</td>
			<td width="20%" class="tdcenter">To</td>
			<td width="17%" class="tdcenter">Depart</td>
			<td width="17%" class="tdcenter">Return</td>
			<td width="10%" class="tdcenter">Traveler</td>
		</tr>
		<tr>
            <td><select id="trip" name="trip" style="width:140px !important;">
                    <option value="oneway" selected>One Way</option>
                    <option value="roundtrip">Round Trip</option>
                </select>
            <td><select id="fromport" name="fromport" style="width:170px !important;">
                    <%
                        for (int i = 0; i < portList.size(); i++) {
                            Port port = portList.get(i);
                    %>
                    <option value="<%=port.getId()%>"><%=port.getName()%></option>
                    <%
                       } 
                    %>
                </select></td>
            <td><select id="toport" name="toport" style="width:170px !important;">
					<%
						for (int i = 0; i < portList.size(); i++) {
							Port port = portList.get(i);
					%>
					<option value="<%=port.getId()%>"><%=port.getName()%></option>
					<%
					   } 
					%>
			</select></td>
            <td><input id="departdate" type="date" name="departdate" ></td>
            <td><input id="returndate" type="date" name="returndate" ></td>
            <td><input id="travelernumber" type="text" name="travelernumber"></td>
        </tr>

		<tr>
			<td colspan="6" align="right"  class="bottomBorderLess"><br/><input id="submit" type="button" value="Home" onclick="window.location.href='userlogged.jsp'"/>&nbsp;&nbsp;<input id="submit" type="button" value="Find Routes" onclick="searchRoute();return false;"/></td>
		</tr>
		
	</table>
	
</form>
<div id="content"></div>
<%@include file="footer.jsp"%>