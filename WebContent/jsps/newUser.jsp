<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
	<form action="/budget/registerUser">
		userName: <input type="text" name="userName" /><br/>
		firstName: <input type="text" name="firstName" /><br/>
		lastName<input type="text" name="lastName" /><br/>
		email: <input type="text" name="email" /><br/>
		mobile: <input type="text" name="mobile" /><br/>
		Gender: <input type="text" name="sex" /><br/>
		Date Of Birth: <input type="text" name="dateOfBirth" /><br/>
		Password: <input type="password" name="password" /><br/>
		<button type="submit">Register</button>
	</form>
</body>
</html>