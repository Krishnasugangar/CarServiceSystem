package com.gqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changePasswordController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPassword = request.getParameter("newPassword");
		String confirmNewPassword = request.getParameter("confirmNewPassword");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("susername");
		if(!newPassword.equals(confirmNewPassword)) {
			response.sendRedirect("/carservicesystem/newPasswordMismatch.jsp");
			
		}
		else {
			
		}
	}


}

