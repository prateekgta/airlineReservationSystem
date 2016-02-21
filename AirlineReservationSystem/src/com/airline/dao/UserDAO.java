package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airline.db.DBConnection;

public class UserDAO extends DBConnection{

	public boolean validateUser(int userId, String pwd){
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from UserDetails where user_id=? and password=?");
			pstmt.setInt(1, userId);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(con);
		}
		
		return false;
	}
	
	/*public boolean registerUser(UserBean user){
		
		return false;
	}*/
}
