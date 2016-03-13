<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
tr.spaceUnder>td {
	padding-bottom: 1em;
}
</style>
<script>
    function validateForm() {
        var un = document.loginform.email.value;
        var pw = document.loginform.password.value;
        if ((un == '') || (pw == '')) {
            alert("Both fields are mandatory");
            return false;
        }
      }
</script>
</head>
<body>
	<form name="loginform" action="LoginController">
		<h1 align="center">ADAPTIVE WEB PROJECT</h1>
		<div id="login-box" align="center">
			<table>
				<tr>
					<td>Email Address:</td>
					<td><input type='text' name='email'></td>
				</tr>
				<tr class="spaceUnder">
					<td>Password :</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr class="spaceUnder">
					<td></td>
					<td align="center"><input name="submit" type="submit"
						value="submit" onclick=" return validateForm()"/></td>
				</tr>
				<tr>
					<td></td>
					<td align="center">Register <a href="register.jsp">here</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>