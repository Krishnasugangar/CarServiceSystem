package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {
	private String cartype;
	private String carmodel;
	private String carregno;
	private String username;
	private String serviceType;
	private String serviceStatus;
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCarregno() {
		return carregno;
	}
	public void setCarregno(String carregno) {
		this.carregno = carregno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	public Car(String cartype, String carmodel, String carregno, String username, String serviceType,
			String serviceStatus) {
		super();
		this.cartype = cartype;
		this.carmodel = carmodel;
		this.carregno = carregno;
		this.username = username;
		this.serviceType = serviceType;
		this.serviceStatus = serviceStatus;
	}
	
	public Car() {
		super();
	}
	public int addCarDetails() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem","root","root");
			String sql = "insert into car values(?,?,?,?,?,?)";//car = table name;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);//username = instance variable
			pstmt.setString(2,cartype);//cartype = instance variable
			pstmt.setString(3,carmodel);//.............
			pstmt.setString(4,carregno);//........
			pstmt.setString(5,"null");
			pstmt.setString(6, "null");
			int rows = pstmt.executeUpdate();
			return rows;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public int addServiceDetails() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem","root","root");
			String sql = "update car set servicetype=?, servicestatus=? where username=?";//car = table name;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,serviceType);
			pstmt.setString(2, "in progress");
			pstmt.setString(3,username);
			int rows = pstmt.executeUpdate();
			return rows;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public String serviceStatus() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservicesystem","root","root");
			String sql = "select * from car where username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				serviceStatus = res.getString(6);
			}
			return serviceStatus;
		}catch(Exception e) {
			
		}
		return null;
	}

}
