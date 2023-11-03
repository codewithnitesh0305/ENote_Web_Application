package com.Servlet;

import java.io.IOException;

import com.DAO.userDAO;
import com.DB.DBConnection;
import com.User.userDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		
		userDetails user = new userDetails();
		user.setEmail(email);
		user.setPassword(password);
		
		userDAO userDAO = new userDAO(DBConnection.getConnection());
		userDetails us = userDAO.loginUser(user);
		
		HttpSession session = req.getSession();
		if(us != null) {
			session.setAttribute("userD", us);
			resp.sendRedirect("home.jsp");
		}
		else {
			session.setAttribute("login-failed", "Invalid Email and Password");
			resp.sendRedirect("login.jsp");
		}
	
	}
	
}
