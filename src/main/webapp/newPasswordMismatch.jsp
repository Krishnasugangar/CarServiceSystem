<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>new password and confirm new password does not match</h1>
    <form action="/carservicesystem/changePasswordController">
        <table>
            <tr>
                <td>Enter new Password</td>
                <td><input type="password" name="newPassword" placeholder="Enter the password"/></td>
            </tr>
            <tr>
                <td>Confirm new  Password</td>
                <td><input type="password" name="confirmNewPassword" placeholder="Confirm Password" /></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="submit"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
