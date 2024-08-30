package com.gqt.controller;

import com.gqt.model.ServiceRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminServiceRequests")
public class AdminServiceRequests extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem", "root", "root");
            String sql = "SELECT * FROM car";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            
            while (res.next()) {
                ServiceRequest sr = new ServiceRequest();
                sr.setUsername(res.getString("username"));
                sr.setCarType(res.getString("cartype"));
                sr.setCarModel(res.getString("carmodel"));
                sr.setCarRegNo(res.getString("carregno"));
                sr.setServiceType(res.getString("service_type"));
                sr.setServiceStatus(res.getString("service_status"));
                serviceRequests.add(sr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Store the list in request scope
        request.setAttribute("serviceRequests", serviceRequests);
        
        // Forward to JSP to display results
        request.getRequestDispatcher("/admin/viewServiceRequests.jsp").forward(request, response);
    }
}
