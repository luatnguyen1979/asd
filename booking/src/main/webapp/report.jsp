<%@include file="header.jsp"%>
<%@ page import="asd.booking.domain.Report,java.util.List,java.util.ArrayList"%>

<%

ArrayList<Report> reportList = (ArrayList<Report>) session.getAttribute("reportlist");

%>

<h2>Passenger List</h2>
<form id="passengerlist" action="confirmcheckingout" method="POST">
	<table width="800px" border=1>
		<tr>
			<td colspan="6" class="section" align="center">Passenger Information:</td>

		</tr>
		
		<tr>
		<td width="7" class="tdcenter">No</td>
			<td width="15%" class="tdcenter">Train Name</td>
			<td width="20%" class="tdcenter">Depart Date</td>
			<td width="20%" class="tdcenter">From</td>
			<td width="20%" class="tdcenter">To</td>
			<td width="10%" class="tdcenter">Passenger Quantity</td>
			<td width="10%" class="tdcenter">Sum Price</td>

		</tr>
		
<%for (int i = 0; i < reportList.size(); i ++) {
	Report report = reportList.get(i);
%>
<tr>
            <td ><%=i + 1 %></td>
            <td ><%=report.getTrainName() %></td>
            <td ><%=report.getDate()%></td>
            <td ><%=report.getSourceName()%></td>
            <td ><%=report.getDestName()%></td>
            <td ><%=report.getPassenger()%></td>
            <td ><%=report.getTotalPrice()%></td>

        </tr>
<% } 
%>

		<tr>
			<td colspan="7" align="right" class="bottomBorderLess"><input id="submit" type="button" value="Home" onclick="window.location.href='userlogged.jsp'"/></td>
		</tr>
		
	</table>
	
</form>

<%@include file="footer.jsp"%>