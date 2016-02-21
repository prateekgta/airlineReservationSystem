package com.airline.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.beans.FlightBean;
import com.airline.dao.FlightDAO;

/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String src = req.getParameter("source");
		String dest = req.getParameter("destination");
		FlightDAO flightDAO = new FlightDAO();
		List<FlightBean> listOfFlights = flightDAO.getFlights(src, dest);
		req.setAttribute("listOfFlights", listOfFlights);
		
		RequestDispatcher rd = req.getRequestDispatcher("searchResult.jsp");
		rd.forward(req, res);
		
	}

}
