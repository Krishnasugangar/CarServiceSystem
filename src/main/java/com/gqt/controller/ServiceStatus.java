package com.gqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;

public class ServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("susername");
		Car tempCar = new Car();
		tempCar.setUsername(username);
		String serviceStatus = tempCar.serviceStatus();
		if(serviceStatus.equals("in progress")) {
			response.sendRedirect("/carservicesystem/serviceStatusProgress.jsp");
		}
		else if(serviceStatus.equals("completed")) {
			response.sendRedirect("/carservicesystem/serviceStatusCompleted.jsp");
		}
		else {
			response.sendRedirect("/carservicesystem/serviceStatusFailure.jsp");
		}
	}
}