package com.airline.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static{
		//load the driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("driver loaded.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection con = null;
		try {
			con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.72.3:1521:orcl","orad181","priyapoo");
			System.out.println("connection created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con){
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		Connection con = new DBConnection().getConnection();
	}
}
