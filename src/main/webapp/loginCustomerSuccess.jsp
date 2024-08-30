<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String)session.getAttribute("sname");
out.println("Dear "+name+", you have logged in");
%>
<br>
<form action="" method="get">
    <button type="submit" formaction="addCarDetails.jsp">Add Car Details</button><br>
    <button type="submit" formaction="RequestForAService.jsp">Request for service</button><br>
    <button type="submit" formaction="ServiceStatus">Check service status</button><br>
    <button type="submit" formaction="changePassword.jsp">Change password</button><br>
    <button type="submit" formaction="editCarDetailsServlet">Edit car details</button><br>
</form>
</body>
</html>
