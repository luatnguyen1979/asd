<%@include file="header.jsp"%>
<h1>Login to Train Booking System</h1>
<form action="login">
	<table>
		<tr>
			<td>Please enter your username</td>
			<td><input type="text" name="un" /></td>
		</tr>

		<tr>
			<td>Please enter your password</td>
			<td><input type="text" name="pw" /></td>
		</tr>

		<tr>
			<td colspan=2 align="center"><input type="submit" value="submit"></td>
		</tr>
	</table>
</form>
<%@include file="footer.jsp"%>