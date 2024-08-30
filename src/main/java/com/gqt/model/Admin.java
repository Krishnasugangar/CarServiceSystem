package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private String username;
	private String password;
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
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
	}
	public int loginAdmin() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem","root","root");
			String sql = "select * from admin where username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				if(password.equals(res.getString(2))) {
					password = res.getString(2);
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
