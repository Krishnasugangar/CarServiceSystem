<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Service Requests</h1>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Car Type</th>
            <th>Car Model</th>
            <th>Car Reg No</th>
            <th>Service Type</th>
            <th>Service Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="sr" items="${serviceRequests}">
            <tr>
                <td>${sr.username}</td>
                <td>${sr.carType}</td>
                <td>${sr.carModel}</td>
                <td>${sr.carRegNo}</td>
                <td>${sr.serviceType}</td>
                <td>${sr.serviceStatus}</td>
                <td>
                    <form action="UpdateServiceStatus" method="post">
                        <input type="hidden" name="username" value="${sr.username}" />
                        <select name="serviceStatus">
                            <option value="in progress">In Progress</option>
                            <option value="completed">Completed</option>
                        </select>
                        <input type="submit" value="Update" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>