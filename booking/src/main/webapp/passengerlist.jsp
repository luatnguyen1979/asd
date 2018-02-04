<%@include file="header.jsp"%>

<%

Integer numberPassenger = (Integer) session.getAttribute("numberpassenger");

%>


<h2>Passenger List</h2>
<form id="passengerlist" action="confirmcheckingout" method="POST">
	<table width="800px" border=1>
		<tr>
			<td colspan="3" class="section" align="center">Passenger Information:</td>

		</tr>
		
		<tr>
			<td width="10%" class="tdcenter">No</td>
			<td width="60%" class="tdcenter">Full Name</td>
			<td width="30%" class="tdcenter">Passenger Type</td>

		</tr>
		
<%for (int i = 0; i < numberPassenger; i ++) {%>
<tr>
            <td width="10%"><%=i + 1 %></td>
            <td width="60%"><input size=50 type=text name="fullname<%= i + 1%>"></td>
            <td width="30%"><select id="passengerType" name="passengertype<%= i + 1%>" style="width:140px !important;">
                    <option value="senior">Senior</option>
                    <option value="sdult" selected>Adult</option>
                    <option value="military">Military</option>
                    <option value="child">Child</option>
                    <option value="infant">Infant</option>
                </select></td>

        </tr>
<% } 
%>
        <tr>
            <td colspan="3" align="right" class="bottomBorderLess">Promotion Code: <input type="text" name="promotioncode" size=10/></td>
        </tr>
		<tr>
			<td colspan="3" align="right" class="bottomBorderLess"><input id="submit" type="button" value="Home" onclick="window.location.href='userlogged.jsp'"/>&nbsp;&nbsp;<input type="submit" value="Checkout" /></td>
		</tr>
		
	</table>
	
</form>

<%@include file="footer.jsp"%>