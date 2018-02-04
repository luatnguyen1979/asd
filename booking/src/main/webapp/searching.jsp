<%@include file="header.jsp"%>
<h2>See Where the Train Can Take You</h2>
<form action="searchschedule" method="POST">
	<table width="1024px" >
		<tr>
			<td colspan="6" class="section">Book Tickets:</td>

		</tr>
		<tr>
			<td width="20%">From</td>
			<td width="20%">To</td>
			<td width="17%">Depart</td>
			<td width="17%">Arrival</td>
		</tr>
		<tr>
            <td><select name="from" style="width:170px !important;">
                    <option value="1">Burlington, IA - BRL</option>
                    <option value="5">Mt. Pleasant, IA - MTP</option>
                    <option value="14">Union Station</option>    
                    <option value="8">Alton, IL - ALN</option>
                </select></td>
            <td><select name="to" style="width:170px !important;">
                    <option value="1">Burlington, IA - BRL</option>
                    <option value="4">Mt. Pleasant, IA - MTP</option>
                    <option value="14">Union Station</option>    
                    <option value="9">Carbondale, IL - CDL</option>    
                </select></td>
            <td><input type="date" name="depart" ></td>
            <td><input type="date" name="arrival" ></td>
        </tr>
		<tr>
			<td colspan="6" align="right"><input
				type="submit" value="Find Trains"></td>
		</tr>
	</table>
</form>
<%@include file="footer.jsp"%>