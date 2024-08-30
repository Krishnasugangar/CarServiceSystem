package com.gqt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;

public class RequestForAService extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceType = request.getParameter("waterService");
		System.out.println(serviceType);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("susername");
		Car tempCar = new Car();
		tempCar.setUsername(username);
		tempCar.setServiceType(serviceType);
		int status = tempCar.addServiceDetails();
		if(status==0) {
			response.sendRedirect("/carservicesystem/RequestForAServiceFailure.jsp");
		}
		else {
			response.sendRedirect("/carservicesystem/RequestForAServiceSuccess.jsp");
		}	
	}
}