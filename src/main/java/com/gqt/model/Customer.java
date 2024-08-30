package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Customer() {
		super();
	}
	public int getDetails() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem","root","root");
			String sql = "select * from customer where username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet res = pstmt.executeQuery();
			if(res.next()==true) {
				return -1;
			}
			else {
				
				
				String sql1 = "insert into customer values(?,?,?,?)";
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				
				pstmt1.setString(1,name);
				pstmt1.setString(2,username);
				pstmt1.setString(3,password);
				pstmt1.setString(4,email);
				int rows = pstmt1.executeUpdate();
				return rows;
			} 
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int loginCustomer() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("driver loaded ");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem","root","root");
			System.out.println("connection");
			String sql = "select * from customer where username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				if(password.equals(res.getString(3))) {
					name = res.getString(1);
					return 1;//valid customer
				}
				else {
					return 0;//invalid password
				}
			}
			else {
				return -1;//invalid username
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return 0;
		
	}

}