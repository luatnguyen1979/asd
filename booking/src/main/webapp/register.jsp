<%@include file="header.jsp"%>
<h2>New customer registration</h2>
<form action="registercustomer" method="POST">
	<table>
		<tr>
			<td colspan="2" class="section">Customer Information:</td>

		</tr>
		<tr>
			<td>User Name:</td>
			<td><input type="text" name="username" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="text" name="password" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstName" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastName" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>Cell Phone:</td>
			<td><input type="text" name="cellPhone" /></td>
		</tr>

		<tr>
			<td colspan="2" class="section">Address:</td>

		</tr>
		<tr>
			<td>Street 1:</td>
			<td><input type="text" name="street1" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>Street 2:</td>
			<td><input type="text" name="street2" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="city" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>Zip Code:</td>
			<td><input type="text" name="zipCode" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="state" /><span class="required">&nbsp;&nbsp;*</span></td>
		</tr>
		<tr>
			<td colspan="2" class="section">Payment:</td>

		</tr>
		<tr>
			<td>Card Type:</td>
			<td><select name="cardType" width="10">
					<option value="visa" selected>VISA</option>
					<option value="mastercard">MASTERCARD</option>
					<option value="discover">DISCOVER</option>
					<option value="jcb">JCB</option>

			</select></td>
		</tr>
		<tr>
			<td>Holder Name:</td>
			<td><input type="text" name="holderName" /></td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><input type="text" name="cardNumber" /></td>
		</tr>
		<tr>
			<td>Expiration(mm/yyyy):</td>
			<td><input type="text" size="2" name="expiredMonth"
				placeholder="mm" />/<input type="text" size="4" name="expiredYear"
				placeholder="yyyy" /></td>
		</tr>
		<tr>
			<td>CCV:</td>
			<td><input type="text" name="ccv" /></td>
		</tr>

		<tr>
			<td colspan="2" class="section">Billing Address: <input
				name="isSameAddress" type="checkbox"> user Customer Address
			</td>

		</tr>
		<tr>
			<td>Street 1:</td>
			<td><input type="text" name="payment_street1" /></td>
		</tr>
		<tr>
			<td>Street 2:</td>
			<td><input type="text" name="payment_street2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="payment_city" /></td>
		</tr>
		<tr>
			<td>Zip Code:</td>
			<td><input type="text" name="payment_zipCode" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="payment_state" /></td>
		</tr>

		<tr>
			<td colspan=2 align="right"><input type="reset" value="Reset"><input
				type="submit" value="submit"><input type="button"
				value="Cancel"></td>
		</tr>
	</table>
</form>
<%@include file="footer.jsp"%>