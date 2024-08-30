<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Invalid Password</h1>
<form action="/carservicesystem/LoginCustomerController">
<table>
	<tr>
		<td>USERNAME</td>
		<td><input type="text" name="username" placeholder="Enter the username"/></td>
	</tr>
	<tr>
		<td>PASSWORD</td>
		<td><input type="text" name="password" placeholder="Enter the password"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
	</tr>
</table>
</form>
</body>
</html>
