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
    function validate() {
        var fn = document.registerform.firstname.value;
        var ln = document.registerform.lastname.value;
        var em = document.registerform.email.value;
        var pw = document.registerform.password.value;
        var cpw = document.registerform.confirmpassword.value;
        if ((fn == '') || (ln == '') || (em == '') || (pw == '')) {
            alert("All fields are mandatory");
            return false;
        }
        else if(pw!=cpw){
        	alert("Both the passwords should match");
        	return false;
        }
      }
</script>
</head>
<body>
	<form name="registerform" action="RegisterController">
		<h1 align="center">ADAPTIVE WEB PROJECT</h1>
		<div id="login-box" align="center">
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type='text' name='firstname'></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type='text' name='lastname'></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type='text' name='email'></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr class="spaceUnder">
					<td>Confirm Password :</td>
					<td><input type='password' name='confirmpassword' /></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input name="submit" type="submit"
						value="submit" onclick=" return validate()"/></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>