<%@include file="header.jsp"%>
<h2>Login to Train Booking System</h2>
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
			<td colspan=2 align="right"><input type="submit" value="Login"></td>
		</tr>
	</table>
</form>
<%@include file="footer.jsp"%>