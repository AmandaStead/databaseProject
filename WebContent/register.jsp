<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="register">
			<table border="1" cellpadding="5">
				<tr>
					<th>Username: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Birthday: </th>
					<td align="center" colspan="3">
						<input type="text" name="birthday" size="45" value="YYYY-MM-DD" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>cc_num: </th>
					<td align="center" colspan="3">
						<input type="text" name="cc_num" size="45" value="cc_num" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>cc_exp: </th>
					<td align="center" colspan="3">
						<input type="text" name="cc_exp" size="45" value="cc_exp" onfocus="this.value=''">
					</td>
				<tr>	
				<tr>
				<th>cc_cvv: </th>
					<td align="center" colspan="3">
						<input type="text" name="cc_cvv" size="45" value="cc_cvv" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>adress_street_num: </th>
					<td align="center" colspan="3">
						<input type="text" name="adress_street_num" size="45" value="adress_street_num" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>adress_street: </th>
					<td align="center" colspan="3">
						<input type="text" name="adress_street" size="45" value="adress_street" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>adress_city: </th>
					<td align="center" colspan="3">
						<input type="text" name="adress_city" size="45" value="adress_city" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>adress_state: </th>
					<td align="center" colspan="3">
						<input type="text" name="adress_state" size="45" value="adress_state" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>adress_zip_code: </th>
					<td align="center" colspan="3">
						<input type="text" name="adress_zip_code" size="45" value="adress_zip_code" onfocus="this.value=''">
					</td>
				<tr>
				<tr>
				<th>phone: </th>
					<td align="center" colspan="3">
						<input type="text" name="phone" size="45" value="1234567891" onfocus="this.value=''">
					</td>
				<tr>
	
				</tr>
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>