package com.gqt.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/UpdateServiceStatus")
public class UpdateServiceStatus extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String serviceStatus = request.getParameter("serviceStatus");
        
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem", "root", "root");
            String sql = "UPDATE car SET service_status = ? WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, serviceStatus);
            pstmt.setString(2, username);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("/admin/updateSuccess.jsp");
            } else {
                response.sendRedirect("/admin/updateFailure.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
