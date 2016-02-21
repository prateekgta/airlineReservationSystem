package com.airline.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userId =req.getParameter("userId");
		String pwd = req.getParameter("pwd");
		UserDAO useDAO = new UserDAO();
		boolean flag =useDAO.validateUser(Integer.parseInt(userId), pwd);
				
	    if(flag){
	    	HttpSession session = req.getSession(); //return new session or existing session if already exists
	    	session.setAttribute("userId", userId);
	    	//login successful
	    	RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
	    	rd.forward(req, res);
	    }else{
	    	//login failed.
	    	res.sendRedirect("index.jsp?event=loginFailed");
	    }
		
	}

}
