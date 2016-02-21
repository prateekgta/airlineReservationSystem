package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.beans.FlightBean;
import com.airline.db.DBConnection;

public class FlightDAO extends DBConnection{

	public List<FlightBean> getFlights(String source,String destination){
		List<FlightBean> listOfFlights = new ArrayList<FlightBean>();
		FlightBean bean = null;
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from FlightDetails where source=? and destination=?");
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new FlightBean();
				bean.setFlightId(rs.getInt(1));
				bean.setFlightName(rs.getString(2));
				bean.setSource(source);
				bean.setDestination(destination);
				bean.setFare(rs.getDouble(5));
				
				listOfFlights.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(con);
		}
		
		return listOfFlights;
	}
}
